package com.pierreherbelin.drivy.domain.service

import com.pierreherbelin.drivy.domain.data.Car
import io.reactivex.Single

interface ICarsService {
    /**
     * Fetch available cars from the backend
     */
    fun fetchAvailableCars(): Single<List<Car>>
}