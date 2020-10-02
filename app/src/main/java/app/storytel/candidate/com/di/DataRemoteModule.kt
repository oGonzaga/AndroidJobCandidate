package app.storytel.candidate.com.di

import app.storytel.candidate.com.data_remote.RestClientFactory
import org.koin.dsl.module

val dataRemoteModule = module {
    single { RestClientFactory.provideRetrofit() }
    factory { RestClientFactory.provideApi(get()) }
}