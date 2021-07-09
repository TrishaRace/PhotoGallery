package com.trisharace.photogallery.generalGallery.photoGalleryList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.trisharace.generalgallery.domain.usecases.GetPhotosUseCase
import com.example.exception.Failure
import com.example.extensions.cancelIfActive
import com.example.platform.BaseViewModel
import com.trisharace.core.utilities.Error
import com.trisharace.core.utilities.Success
import com.trisharace.generalgallery.models.view.PhotoView
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PhotoGalleryViewModel(
    private val getPhotosUseCase: GetPhotosUseCase
) : BaseViewModel() {

    private var getForecastsJob: Job? = null

    private var _photos = MutableLiveData<List<PhotoView>>()
    val photos get() = _photos

    fun getPhotos() {
        getForecastsJob.cancelIfActive()
        getForecastsJob = viewModelScope.launch {
            getPhotosUseCase()
                .onStart { handleShowSpinner(true) }
                .onCompletion { handleShowSpinner(false) }
                .catch { handleFailure(Failure.Throwable(it)) }
                .collect { result ->
                    when (result) {
                        is Success<List<PhotoView>> -> {
                            _photos.value = result.data
                        }
                        is Error -> {
                            handleFailure(result.failure)
                        }
                    }
                }
        }
    }
}