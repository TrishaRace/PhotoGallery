package com.trisharace.generalgallery.data.datasource

import android.util.Log
import com.trisharace.generalgallery.data.service.PhotoService
import com.trisharace.generalgallery.models.view.PhotoView
import com.example.exception.Failure
import com.trisharace.core.platform.NetworkHandler
import com.trisharace.core.utilities.State
import com.trisharace.core.utilities.Success
import com.trisharace.core.utilities.Error
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class PhotosDataSourceImp(
    private val networkHandler: NetworkHandler,
    private val service: PhotoService
) : PhotosDataSource {

    override fun getPhotos(
    ) = flow {
        emit(getPhotosFromService())
    }.catch {
        Log.i("resultado",it.message.toString())
        emit(Error(Failure.Throwable(it)))
    }

    override fun getPhotoDetail(id: String) = flow {
        emit(getPhotoDetailFromService(id))
    }.catch {
        emit(Error(Failure.Throwable(it)))
    }

    private suspend fun getPhotosFromService(): State<List<PhotoView>> {
        return if (networkHandler.isConnected == true) {
            service.getPhotos().run {
                Log.i("resultado",this.isSuccessful.toString())
                if (this.isSuccessful && this.body() != null) {
                    val data = this.body()!!
                    Log.i("resultado",data.toString())
                    return Success(data.map{it.toPhoto()}.map {
                        it.toPhotoView() })
                } else {
                    Error(Failure.ServerError(code()))
                }
            }
        } else {
            Log.i("resultado","error ")
            Error(Failure.NetworkConnection)
        }
    }

    private suspend fun getPhotoDetailFromService(id:String): State<PhotoView> {
        return if (networkHandler.isConnected == true) {
            service.getPhotoDetail(id).run {
                if (this.isSuccessful && this.body() != null) {
                     Success(this.body()!!.toPhoto().toPhotoView())
                } else {
                    Error(Failure.ServerError(code()))
                }
            }
        } else {
            Error(Failure.NetworkConnection)
        }
    }
}