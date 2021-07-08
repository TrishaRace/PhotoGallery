package com.trisharace.photogallery.core.di

import com.trisharace.photogallery.generalGallery.photoDetail.PhotoDetailViewModel
import com.trisharace.photogallery.generalGallery.photoGalleryList.PhotoGalleryViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val photosViewModelModule = module {
    viewModel { PhotoGalleryViewModel(get()) }
}
val photoDetailViewModelModule = module {
    viewModel { PhotoDetailViewModel(get()) }
}