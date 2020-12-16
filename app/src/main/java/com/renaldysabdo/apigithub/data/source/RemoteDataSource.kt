package com.renaldysabdo.apigithub.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.renaldysabdo.apigithub.data.response.UserResponse
import com.renaldysabdo.apigithub.data.service.ApiService
import kotlinx.coroutines.flow.Flow

class RemoteDataSource(private val service: ApiService) {

    fun searchUser(name: String) : Flow<PagingData<UserResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GithubPagingSource(
                    service, name
                )
            }
        ).flow
    }
}