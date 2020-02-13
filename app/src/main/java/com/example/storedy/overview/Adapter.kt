package com.example.mybar.overview

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.storedy.api.StoresItem
import com.example.storedy.R
import com.example.storedy.detail.DetailActivity
import com.example.storedy.utils.inflate
import kotlinx.android.synthetic.main.item_store.view.*

class Adapter(val data:List<StoresItem>): RecyclerView.Adapter<Adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(
            parent?.inflate(R.layout.item_store)
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindView(data[position])
    }

    class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        fun bindView(storesItem: StoresItem){
            with(storesItem){
                itemView.txtTitleItem.text = name

                storeLogoURL?.let {
                    val imgUri = storeLogoURL.toUri().buildUpon().scheme("http").build()
                    Glide.with(itemView.context)
                        .load(imgUri)
                        .apply(
                            RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image))
                        .into(itemView.imageItemHeader)
                }


                itemView.setOnClickListener {

                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("store", storesItem )
                    itemView.context.startActivity(intent)
                }


            }

        }

    }
}