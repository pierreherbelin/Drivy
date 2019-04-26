package com.pierreherbelin.drivy.domain.service

import com.google.gson.GsonBuilder
import com.pierreherbelin.drivy.domain.data.Car
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CarsServiceImpl(hostname: String) : ICarsService {

    private var mApiManager: ICarsServiceBuilder

    init {
        val okHttpClient = OkHttpClient.Builder()
            .hostnameVerifier { _, _ -> true }
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val sRetrofit = Retrofit.Builder().baseUrl(hostname)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()

        mApiManager = sRetrofit.create(ICarsServiceBuilder::class.java)
    }


    override fun fetchAvailableCars(): Single<List<Car>> {
        return Single.create { observer ->
            try {
                mApiManager.fetchAvailableCars().execute()?.let {
                    if (it.isSuccessful) {
                        observer.onSuccess(it.body() ?: ArrayList())
                    } else {
                        observer.onError(Throwable())
                    }
                }
            } catch (e: Exception) {
                if (!observer.isDisposed) {
                    observer.onError(Throwable(e))
                }
            }
        }
    }
}