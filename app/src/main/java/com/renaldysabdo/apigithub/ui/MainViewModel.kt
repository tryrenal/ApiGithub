package com.renaldysabdo.apigithub.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.renaldysabdo.apigithub.domain.usecase.GithubUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest

class MainViewModel (private val usecase: GithubUseCase) : ViewModel(){
    val query : MutableLiveData<String> = MutableLiveData("tryrenal")

    @FlowPreview
    @ExperimentalCoroutinesApi
    val users = query.asFlow()
        .debounce(300)
        .distinctUntilChanged()
        .flatMapLatest {
            searchUser(it)
        }.asLiveData()

    private fun searchUser(name: String) = usecase.searchUser(name)
}