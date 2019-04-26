package com.pierreherbelin.drivy.carslist.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel

abstract class BasePresenter<View> : ViewModel(), LifecycleObserver {

    private var mView: View? = null
    private var mViewLifecycle: Lifecycle? = null

    fun attachView(view: View, viewLifecycle: Lifecycle) {
        mView = view
        mViewLifecycle = viewLifecycle
        viewLifecycle.addObserver(this)
    }

    protected fun getView(): View? = mView

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onViewDestroyed() {
        mView = null
        mViewLifecycle = null
    }
}