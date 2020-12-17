package com.renaldysabdo.apigithub.ui.adapter.loadstate

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.renaldysabdo.apigithub.databinding.LoadStateFooterBinding

class GithubLoadStateViewHolder(
    private val binding: LoadStateFooterBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState){
        with(binding){
            if (loadState is LoadState.Error){
                errorMsg.text = loadState.error.localizedMessage
            }
            progressBar.isVisible = loadState is LoadState.Loading
            retryButton.isVisible = loadState !is LoadState.Loading
            errorMsg.isVisible = loadState !is LoadState.Loading
        }
    }

    companion object {
        fun create(binding: LoadStateFooterBinding, retry: () -> Unit) : GithubLoadStateViewHolder {
            return GithubLoadStateViewHolder(binding, retry)
        }
    }
}