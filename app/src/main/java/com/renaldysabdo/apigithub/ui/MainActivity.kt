package com.renaldysabdo.apigithub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renaldysabdo.apigithub.databinding.ActivityMainBinding
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

    private lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setSearchUser()
        setData()
        initAdapter()
    }

    private fun initAdapter(){
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mBinding.recyclerMain.layoutManager = layoutManager
        mBinding.recyclerMain.adapter = githubAdapter.withLoadStateFooter(
            footer = GithubLoadStateAdapter { githubAdapter.retry() }
        )
        githubAdapter.addLoadStateListener { loadState ->
            mBinding.recyclerMain.isVisible = loadState.source.refresh is LoadState.NotLoading
            mBinding.pbMain.isVisible = loadState.source.refresh is LoadState.Loading
        }
    }

    private fun setData(){
        mainViewModel.users.observe(this){ data ->
            lifecycleScope.launch {
                githubAdapter.submitData(data)
            }
        }
    }

    private fun setSearchUser(){
        mBinding.svMain.setQuery("tryrenal", true)
        mBinding.svMain.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mainViewModel.query.value = newText
                return true
            }
        })
    }
}