package com.pierreherbelin.drivy.carslist.ui

import com.pierreherbelin.drivy.domain.data.Car

interface ICarsListView {

    /**
     * Populate the recycler with the list of cars
     */
    fun onCarsAvailable(carsList: List<Car>)

    /**
     * Display the error container
     */
    fun displayErrorView()

    /**
     * Display the loading getView
     */
    fun displayLoadingView()
}