package com.renaldysabdo.apigithub.ui.adapter.loadstate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.renaldysabdo.apigithub.databinding.LoadStateFooterBinding

class GithubLoadStateAdapter(private val retry: () -> Unit) : LoadStateAdapter<GithubLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: GithubLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): GithubLoadStateViewHolder {
        val itemBinding = LoadStateFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubLoadStateViewHolder.create(itemBinding, retry)
    }
}