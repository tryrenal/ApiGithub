package com.renaldysabdo.apigithub.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.renaldysabdo.apigithub.R
import com.renaldysabdo.apigithub.domain.model.Users

class GithubViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.content_users, parent, false)
) {
    fun bindData(data: Users?){
        val image = itemView.findViewById<ImageView>(R.id.img_user)
        val name = itemView.findViewById<TextView>(R.id.tv_name_user)

        Glide.with(itemView)
            .load(data?.image)
            .into(image)

        name.text = data?.name
    }
}