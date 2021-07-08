package com.example.extensions

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.delegate.FragmentViewBindingDelegate

inline fun<reified T : ViewBinding> Fragment.viewBinding() =
    FragmentViewBindingDelegate(this, T::class.java)