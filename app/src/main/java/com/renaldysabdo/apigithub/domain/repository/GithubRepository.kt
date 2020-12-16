package com.renaldysabdo.apigithub.domain.repository

import androidx.paging.PagingData
import com.renaldysabdo.apigithub.domain.model.Users
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    fun searchUser(name: String) : Flow<PagingData<Users>>
}