package com.pierreherbelin.drivy.cardetail.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pierreherbelin.drivy.domain.data.Car
import kotlinx.android.synthetic.main.activity_car_detail.*
import android.view.MenuItem


class CarDetailActivity : AppCompatActivity() {

    companion object {
        const val CAR_DETAIL_KEY = "car_detail_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.pierreherbelin.drivy.R.layout.activity_car_detail)
        val car = intent.getParcelableExtra<Car>(CAR_DETAIL_KEY)
        initUI(car)
    }

    private fun initUI(car: Car) {
        detail_car_header_view.buildView(car)
        owner_header_view.buildView(car.owner)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }
}
