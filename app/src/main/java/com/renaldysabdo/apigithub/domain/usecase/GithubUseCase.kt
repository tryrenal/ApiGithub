package com.renaldysabdo.apigithub.domain.usecase

import androidx.paging.PagingData
import com.renaldysabdo.apigithub.domain.model.Users
import kotlinx.coroutines.flow.Flow

interface GithubUseCase {
    fun searchUser(name: String) : Flow<PagingData<Users>>
}