package com.renaldysabdo.apigithub.data.source

import com.renaldysabdo.apigithub.data.response.UserResponse
import com.renaldysabdo.apigithub.data.service.ApiService

class RemoteDataSource(private val service: ApiService) {

    suspend fun searchUser(name: String, page: Int) : List<UserResponse> {
        return service.searchUser(name, page).items
    }
}