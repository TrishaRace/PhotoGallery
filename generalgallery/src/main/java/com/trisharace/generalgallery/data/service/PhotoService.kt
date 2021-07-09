package com.trisharace.generalgallery.data.service

import retrofit2.Retrofit

class PhotoService(retrofit: Retrofit) : PhotoApi {

    private val PhotoApi by lazy { retrofit.create(PhotoApi::class.java) }

    override suspend fun getPhotos() =
        PhotoApi.getPhotos()

    override suspend fun getPhotoDetail(id: String?) = PhotoApi.getPhotoDetail(id)
}
