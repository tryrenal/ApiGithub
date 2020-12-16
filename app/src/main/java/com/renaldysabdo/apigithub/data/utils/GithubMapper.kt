package com.renaldysabdo.apigithub.data.utils

import androidx.paging.PagingData
import androidx.paging.map
import com.renaldysabdo.apigithub.data.response.UserResponse
import com.renaldysabdo.apigithub.domain.model.Users

object GithubMapper {
    fun responseToDomain(input : PagingData<UserResponse>) : PagingData<Users> {
        return input.map {
            Users(
                name = it.name,
                image = it.avatar
            )
        }
    }
}