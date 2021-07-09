package com.trisharace.generalgallery.di

import com.trisharace.generalgallery.data.datasource.PhotosDataSource
import com.trisharace.generalgallery.data.datasource.PhotosDataSourceImp
import com.trisharace.generalgallery.data.repository.PhotosRepositoryImp
import com.trisharace.generalgallery.data.service.PhotoService
import com.trisharace.generalgallery.domain.repository.PhotosRepository
import com.trisharace.generalgallery.domain.usecases.GetPhotoDetailUseCase
import com.trisharace.generalgallery.domain.usecases.GetPhotosUseCase
import org.koin.dsl.module


val photoRepositoryModule = module {
    factory<PhotosRepository> { PhotosRepositoryImp(get()) }
}
val photoDataSourceModule = module {
    factory<PhotosDataSource> { PhotosDataSourceImp(get(),get()) }
}
val photoServiceModule = module {
    factory { PhotoService(get()) }
}

val photoUseCaseModule = module {
    factory { GetPhotosUseCase(get()) }
}

val photoDetailUseCaseModule = module {
    factory { GetPhotoDetailUseCase(get()) }
}

