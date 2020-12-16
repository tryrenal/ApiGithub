package com.renaldysabdo.apigithub.domain.usecase

import androidx.paging.PagingData
import com.renaldysabdo.apigithub.domain.model.Users
import com.renaldysabdo.apigithub.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow

class GithubInteractor(private val repository: GithubRepository) : GithubUseCase {
    override fun searchUser(name: String): Flow<PagingData<Users>> = repository.searchUser(name)
}