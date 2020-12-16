package com.renaldysabdo.apigithub

import android.app.Application
import com.renaldysabdo.apigithub.data.di.networkModule
import com.renaldysabdo.apigithub.data.di.repositoryModule
import com.renaldysabdo.apigithub.domain.di.useCaseModule
import com.renaldysabdo.apigithub.ui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}