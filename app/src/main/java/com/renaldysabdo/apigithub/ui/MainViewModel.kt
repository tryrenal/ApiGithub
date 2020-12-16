package com.renaldysabdo.apigithub.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.renaldysabdo.apigithub.domain.usecase.GithubUseCase

class MainViewModel (private val usecase: GithubUseCase) : ViewModel(){
    fun searchUser(name: String) = usecase.searchUser(name).asLiveData()
}