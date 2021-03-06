package com.trisharace.photogallery.generalGallery.photoDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.trisharace.generalgallery.domain.usecases.GetPhotoDetailUseCase
import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.core.exception.Failure
import com.trisharace.core.extensions.cancelIfActive
import com.trisharace.core.platform.BaseViewModel
import com.trisharace.core.utilities.Error
import com.trisharace.core.utilities.Success
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class PhotoDetailViewModel(
    private val getPhotoDetailUseCase: GetPhotoDetailUseCase
) : BaseViewModel() {

    private var getForecastsJob: Job? = null

    private var _photoDetail = MutableLiveData<PhotoView>()
    val photoDetail get() = _photoDetail

    fun getPhotoDetail(photoId: String) {
        getForecastsJob.cancelIfActive()
        getForecastsJob = viewModelScope.launch {
            getPhotoDetailUseCase(GetPhotoDetailUseCase.Input(photoId))
                .onStart { handleShowSpinner(true) }
                .onCompletion { handleShowSpinner(false) }
                .catch { handleFailure(Failure.Throwable(it)) }
                .collect { result ->
                    when (result) {
                        is Success<PhotoView> -> {
                            _photoDetail.value = result.data
                        }
                        is Error -> {
                            handleFailure(result.failure)
                        }
                    }
                }
        }
    }
}
