package com.renaldysabdo.apigithub.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.renaldysabdo.apigithub.databinding.ContentUsersBinding
import com.renaldysabdo.apigithub.domain.model.Users

class GithubViewHolder(
    private val binding : ContentUsersBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(data: Users?){
        with(binding){
            Glide.with(itemView)
                .load(data?.image)
                .into(imgUser)

            tvNameUser.text = data?.name
        }
    }
}