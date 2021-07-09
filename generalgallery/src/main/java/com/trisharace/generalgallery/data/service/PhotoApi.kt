package com.trisharace.generalgallery.data.service

import com.trisharace.generalgallery.models.entity.PhotoEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface PhotoApi {

    companion object {
        const val PHOTOS = "/photos"
        const val PHOTO = "/photos/{photoId}"
    }

    @GET(PHOTOS)
    suspend fun getPhotos(): Response<List<PhotoEntity>>

    @GET(PHOTO)
    suspend fun getPhotoDetail(@Path("photoId") id: String?): Response<PhotoEntity>

}