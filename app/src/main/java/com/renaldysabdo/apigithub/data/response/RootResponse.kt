package com.renaldysabdo.apigithub.data.response

import com.google.gson.annotations.SerializedName

data class RootResponse(
    @field:SerializedName("items")
    val items : List<UserResponse>
)