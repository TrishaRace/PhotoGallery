package com.trisharace.core.extensions

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.trisharace.core.delegate.FragmentViewBindingDelegate

inline fun<reified T : ViewBinding> Fragment.viewBinding() =
    FragmentViewBindingDelegate(this, T::class.java)