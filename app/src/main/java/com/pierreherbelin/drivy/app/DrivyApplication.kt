package com.pierreherbelin.drivy.app

import android.app.Application
import com.pierreherbelin.drivy.domain.repository.CarsRepositoryImpl
import com.pierreherbelin.drivy.domain.repository.ICarsRepository

/**
 * This is the singleton application
 * Every repository should be initialize here
 * The app configuration should be get and set here
 */
class DrivyApplication : Application() {

    companion object {
        @get:Synchronized
        lateinit var sInstance: DrivyApplication
            private set

        @get:Synchronized
        lateinit var sCarsRepository: ICarsRepository
            private set

        fun getCarsRepository(): ICarsRepository {
            return sCarsRepository
        }
    }

    override fun onCreate() {
        super.onCreate()
        sCarsRepository = CarsRepositoryImpl("https://raw.githubusercontent.com/drivy/jobs/master/android/api/")
    }
}