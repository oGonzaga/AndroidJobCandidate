package app.storytel.candidate.com.di

import app.storytel.candidate.com.ui.detail.PostDetailViewModel
import app.storytel.candidate.com.ui.scrolling.ScrollingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ScrollingViewModel(get()) }
    viewModel { PostDetailViewModel(get()) }
}