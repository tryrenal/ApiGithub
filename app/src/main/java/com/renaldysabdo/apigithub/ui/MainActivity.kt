package com.renaldysabdo.apigithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renaldysabdo.apigithub.R
import com.renaldysabdo.apigithub.ui.adapter.GithubAdapter
import com.renaldysabdo.apigithub.ui.adapter.GithubLoadStateAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

@ExperimentalCoroutinesApi
@FlowPreview
class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by viewModel()
    private val githubAdapter = GithubAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler_main)
        val progress = findViewById<ProgressBar>(R.id.pb_main)
        val search = findViewById<SearchView>(R.id.sv_main)
        search.setQuery("tryrenal", true)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler.layoutManager = layoutManager

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mainViewModel.query.value = newText
                return true
            }
        })

        mainViewModel.users.observe(this){ data ->
            lifecycleScope.launch {
                githubAdapter.submitData(data)
            }
        }

        recycler.adapter = githubAdapter.withLoadStateFooter(
            footer = GithubLoadStateAdapter { githubAdapter.retry() }
        )
        githubAdapter.addLoadStateListener { loadState ->
            recycler.isVisible = loadState.source.refresh is LoadState.NotLoading
            progress.isVisible = loadState.source.refresh is LoadState.Loading
        }
    }
}