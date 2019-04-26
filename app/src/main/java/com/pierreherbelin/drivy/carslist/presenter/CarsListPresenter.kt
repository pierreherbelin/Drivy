package com.pierreherbelin.drivy.carslist.presenter

import com.pierreherbelin.drivy.app.DrivyApplication
import com.pierreherbelin.drivy.carslist.ui.ICarsListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CarsListPresenter : BasePresenter<ICarsListView>(), ICarsListPresenter {

    private var mDisposable: Disposable? = null
    private var mCarsRepository = DrivyApplication.getCarsRepository()

    override fun fetchAvailableCars() {
        mDisposable =
            mCarsRepository.fetchAvailableCars().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    getView()?.onCarsAvailable(it)
                }, {
                    getView()?.displayErrorView()
                })
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable?.dispose()
    }
}