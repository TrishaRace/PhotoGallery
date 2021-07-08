package com.example.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exception.Failure

abstract class BaseViewModel : ViewModel() {

    var _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure get() = _failure

    var _showSpinner: MutableLiveData<Boolean> = MutableLiveData()
    val showSpinner get() = _showSpinner


    protected fun handleFailure(failure: Failure?) {
        this.failure.value = failure
    }

    protected fun handleShowSpinner(show: Boolean) {
        this.showSpinner.value = show
    }
}
