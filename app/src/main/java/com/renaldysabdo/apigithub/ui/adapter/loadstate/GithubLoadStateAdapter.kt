package com.renaldysabdo.apigithub.ui.adapter.loadstate

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class GithubLoadStateAdapter(private val retry: () -> Unit) : LoadStateAdapter<GithubLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: GithubLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): GithubLoadStateViewHolder {
        return GithubLoadStateViewHolder.create(parent, retry)
    }
}