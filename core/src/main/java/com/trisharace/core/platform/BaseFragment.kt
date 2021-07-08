package com.example.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exception.Failure

open class BaseFragment(private val layout: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layout, container, false)

    fun showLoading(showLoading: Boolean) = {}//TODO
    fun showError(failure: Failure) = {}//TODO
}