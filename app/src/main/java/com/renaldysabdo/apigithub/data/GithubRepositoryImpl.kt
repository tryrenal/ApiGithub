package com.renaldysabdo.apigithub.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.renaldysabdo.apigithub.data.source.GithubPagingSource
import com.renaldysabdo.apigithub.data.source.RemoteDataSource
import com.renaldysabdo.apigithub.data.utils.GithubMapper
import com.renaldysabdo.apigithub.domain.model.Users
import com.renaldysabdo.apigithub.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map

class GithubRepositoryImpl (private val remote : RemoteDataSource) : GithubRepository {
    override fun searchUser(name: String): Flow<PagingData<Users>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = true),
            pagingSourceFactory = {
                GithubPagingSource(
                    remote, name
                )
            }
        ).flow
            .map {
                GithubMapper.responseToDomain(it)
            }
    }
}