package com.thalles.firstmvvm.dependencyInjection

import com.thalles.firstmvvm.data.Database
import com.thalles.firstmvvm.data.NotaManager
import com.thalles.firstmvvm.viewmodel.NotaViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DependencyModules {
    val appModule = module {
        // create a single instance
        single { Database() }
        // create a new instance every time is needed
        factory { NotaManager(get()) }
        // instance of viewModel
        viewModel { NotaViewModel(get()) }
    }
}