package com.example.storedy.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.storedy.api.StoresItem
import com.example.storedy.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.card_store_detail.*
import kotlinx.android.synthetic.main.card_store_detail.txtInstructionsDetail

class DetailActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val store: StoresItem = intent.getParcelableExtra("store")

       /* val imgUri = store.storeLogoURL!!.toUri().buildUpon().scheme("http").build()
        Glide.with(this)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imgDetail)*/


        // Add a marker in Sydney and move the camera


        /*mapView.onCreate(savedInstanceState)
        mapView.getMapAsync{map ->
            val sydney = LatLng(151.0, 151.0)
            map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        }*/

        txtNameDetail.text = store.name.toString()
        txtInstructionsDetail.text = store.address.toString()
        txtCityDetail.text = "City: ${store.city.toString()}"
        txtPhoneDetail.text = "Phone: ${store.phone.toString()}"
        txtZipDetail.text = "Zip: ${store.zipcode.toString()}"
    }



}
