package com.trisharace.generalgallery.data.service

import com.trisharace.generalgallery.models.entity.PhotosEntity
import com.example.platform.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface PhotoApi {

    companion object {
        const val CHARACTERS = "/v1/public/characters"
        const val CHARACTER = "/v1/public/characters/{characterId}"
    }

    @GET(CHARACTERS)
    suspend fun getPhotos(
        @Query("limit") limit: Int? = 10,
        @Query("offset") offset: Int? = 0
    ): Response<BaseResponse<PhotosEntity>>

    @GET(CHARACTER)
    suspend fun getPhotoDetail(@Path("characterId") id: String?): Response<BaseResponse<PhotosEntity>>

}