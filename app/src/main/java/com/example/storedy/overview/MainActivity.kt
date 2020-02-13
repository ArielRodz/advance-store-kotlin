package com.example.storedy.overview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mybar.overview.Adapter
import com.example.mybar.overview.OverviewViewModel
import com.example.storedy.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_no_connection.*

class MainActivity : AppCompatActivity() {


    private val viewModel: OverviewViewModel by lazy {
        ViewModelProviders.of(this).get(OverviewViewModel::class.java)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewModel.getData(this)
        viewModel.response.observe(this, Observer { listResult ->
            rcViewLanding.layoutManager = GridLayoutManager(this, 2)
            val adapter =  Adapter(listResult)
            rcViewLanding.adapter = adapter

        })
        viewModel.status.observe(this, Observer { Status ->
            when(Status.name){
                "LOADING" -> print("LOADING")
                "DONE" -> progressBarOverView.visibility = View.GONE
                "ERROR" ->{
                    progressBarOverView.visibility = View.GONE
                    cv_no_connection.visibility = View.VISIBLE

                }


            }
        })
    }




}
