package com.renaldysabdo.apigithub.domain.di

import com.renaldysabdo.apigithub.domain.usecase.GithubInteractor
import com.renaldysabdo.apigithub.domain.usecase.GithubUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory <GithubUseCase>{ GithubInteractor(get()) }
}