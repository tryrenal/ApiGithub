package com.renaldysabdo.apigithub.data.service

import com.renaldysabdo.apigithub.data.response.RootResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    suspend fun searchUser(
      @Query("q") name: String,
      @Query("page") page: Int
    ) : RootResponse
}