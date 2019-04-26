package com.pierreherbelin.drivy.carslist.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.pierreherbelin.drivy.R
import com.pierreherbelin.drivy.app.extension.onItemClick
import com.pierreherbelin.drivy.app.listener.RecyclerItemClickListener
import com.pierreherbelin.drivy.cardetail.ui.CarDetailActivity
import com.pierreherbelin.drivy.cardetail.ui.CarDetailActivity.Companion.CAR_DETAIL_KEY
import com.pierreherbelin.drivy.carslist.presenter.CarsListPresenter
import com.pierreherbelin.drivy.carslist.ui.adapter.CarsAdapter
import com.pierreherbelin.drivy.domain.data.Car
import kotlinx.android.synthetic.main.activity_cars_list.*

class CarsListActivity : AppCompatActivity(), ICarsListView {

    private var mCarsList = ArrayList<Car>()
    private var mCarsAdapter = CarsAdapter(mCarsList)
    private lateinit var mPresenter: CarsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars_list)
        mPresenter = CarsListPresenter()
        mPresenter.attachView(this, lifecycle)
        initUI()
        initListener()
        loadData()
    }

    private fun initUI() {
        cars_list_recycler.setHasFixedSize(true)
        cars_list_recycler.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        cars_list_recycler.adapter = mCarsAdapter
    }

    private fun initListener() {
        swipe_refresh_layout.setOnRefreshListener {
            loadData()
        }

        cars_list_recycler.onItemClick(object : RecyclerItemClickListener.OnClickListener {
            override fun onItemClick(position: Int, view: View) {
                val intent = Intent(applicationContext, CarDetailActivity::class.java)
                intent.putExtra(CAR_DETAIL_KEY, mCarsList[position])
                startActivity(intent)
            }
        })
    }

    override fun onCarsAvailable(carsList: List<Car>) {
        swipe_refresh_layout.isRefreshing = false
        error_textview.visibility = View.GONE
        cars_list_recycler.visibility = View.VISIBLE
        mCarsList.clear()
        mCarsList.addAll(carsList)
        cars_list_recycler.adapter?.notifyDataSetChanged()
    }

    override fun displayErrorView() {
        swipe_refresh_layout.isRefreshing = false
        cars_list_recycler.visibility = View.GONE
        error_textview.visibility = View.VISIBLE
    }

    override fun displayLoadingView() {
        cars_list_recycler.visibility = View.GONE
        error_textview.visibility = View.GONE
    }

    private fun loadData() {
        swipe_refresh_layout.isRefreshing = true
        mPresenter.fetchAvailableCars()
    }
}
