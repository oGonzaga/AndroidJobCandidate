package app.storytel.candidate.com.di

import app.storytel.candidate.com.data.Repository
import app.storytel.candidate.com.data.RepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    factory { RepositoryImpl(get()) as Repository }
}