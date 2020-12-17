package com.renaldysabdo.apigithub.ui.adapter.loadstate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.renaldysabdo.apigithub.R

class GithubLoadStateViewHolder(
    view: View,
    retry: () -> Unit
) : RecyclerView.ViewHolder(view) {
    private val btnRetry : Button = itemView.findViewById(R.id.retry_button)
    private val errorMsg : TextView = itemView.findViewById(R.id.error_msg)
    private val progress : ProgressBar = itemView.findViewById(R.id.progress_bar)

    init {


        btnRetry.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState){
        if (loadState is LoadState.Error){
            errorMsg.text = loadState.error.localizedMessage
        }
        progress.isVisible = loadState is LoadState.Loading
        btnRetry.isVisible = loadState !is LoadState.Loading
        errorMsg.isVisible = loadState !is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit) : GithubLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.load_state_footer, parent, false)
            return GithubLoadStateViewHolder(view, retry)
        }
    }
}