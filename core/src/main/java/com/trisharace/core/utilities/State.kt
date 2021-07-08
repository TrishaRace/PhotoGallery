package com.trisharace.core.utilities

import com.example.exception.Failure

sealed class State<out T : Any>

class Success<out T : Any>(val data: T) : State<T>()

class Error(
    val failure: Failure
) : State<Nothing>()
