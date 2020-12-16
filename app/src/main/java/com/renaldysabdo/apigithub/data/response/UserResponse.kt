package com.renaldysabdo.apigithub.data.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @field:SerializedName("id")
    val id : Long,
    @field:SerializedName("avatar_url")
    val avatar : String,
    @field:SerializedName("login")
    val name: String
)