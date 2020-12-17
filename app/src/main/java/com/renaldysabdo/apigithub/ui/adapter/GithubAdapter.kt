package com.renaldysabdo.apigithub.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.renaldysabdo.apigithub.databinding.ContentUsersBinding
import com.renaldysabdo.apigithub.domain.model.Users

class GithubAdapter : PagingDataAdapter<Users, RecyclerView.ViewHolder>(diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Users>(){
            override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as GithubViewHolder
        viewHolder.bindData(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ContentUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubViewHolder(itemBinding)
    }
}