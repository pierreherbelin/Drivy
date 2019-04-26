package com.pierreherbelin.drivy.domain.service

import com.pierreherbelin.drivy.domain.data.Car
import retrofit2.Call
import retrofit2.http.GET

interface ICarsServiceBuilder {
    @GET("cars.json")
    fun fetchAvailableCars(): Call<List<Car>>
}