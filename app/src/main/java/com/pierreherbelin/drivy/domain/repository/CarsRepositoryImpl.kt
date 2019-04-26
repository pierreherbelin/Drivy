package com.pierreherbelin.drivy.domain.repository

import com.pierreherbelin.drivy.domain.data.Car
import com.pierreherbelin.drivy.domain.service.CarsServiceImpl
import io.reactivex.Single

class CarsRepositoryImpl(hostname: String) : ICarsRepository {

    private var mCarService = CarsServiceImpl(hostname)

    override fun fetchAvailableCars(): Single<List<Car>> {
        return mCarService.fetchAvailableCars()
    }
}