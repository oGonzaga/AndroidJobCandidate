package app.storytel.candidate.com.di

import app.storytel.candidate.com.data.PostRepository
import app.storytel.candidate.com.data.PostRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    factory { PostRepositoryImpl(get()) as PostRepository }
}