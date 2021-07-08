package com.trisharace.generalgallery.data.service

import retrofit2.Retrofit

class PhotoService(retrofit: Retrofit) : PhotoApi {

    private val PhotoApi by lazy { retrofit.create(PhotoApi::class.java) }

    override suspend fun getPhotos(limit: Int?, offset: Int?) =
        PhotoApi.getPhotos(limit, offset)

    override suspend fun getPhotoDetail(id: String?) = PhotoApi.getPhotoDetail(id)
}
