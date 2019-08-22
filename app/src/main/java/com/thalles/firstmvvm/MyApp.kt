package com.thalles.firstmvvm

import android.app.Application
import com.thalles.firstmvvm.dependencyInjection.DependencyModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(DependencyModules.appModule)
        }
    }
}