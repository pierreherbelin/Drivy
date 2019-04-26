package com.pierreherbelin.drivy.domain.repository

import com.pierreherbelin.drivy.domain.data.Car
import io.reactivex.Single

interface ICarsRepository {
    /**
     * Fetch available cars from the backend
     */
    fun fetchAvailableCars(): Single<List<Car>>
}