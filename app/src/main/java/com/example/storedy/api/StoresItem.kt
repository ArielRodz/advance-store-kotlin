package com.example.storedy.api

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class StoresItem(

	@Json(name="zipcode")
	val zipcode: String? = null,

	@Json(name="address")
	val address: String? = null,

	@Json(name="city")
	val city: String? = null,

	@Json(name="phone")
	val phone: String? = null,

	@Json(name="latitude")
	val latitude: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="storeLogoURL")
	val storeLogoURL: String? = null,

	@Json(name="state")
	val state: String? = null,

	@Json(name="storeID")
	val storeID: String? = null,

	@Json(name="longitude")
	val longitude: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(zipcode)
		parcel.writeString(address)
		parcel.writeString(city)
		parcel.writeString(phone)
		parcel.writeString(latitude)
		parcel.writeString(name)
		parcel.writeString(storeLogoURL)
		parcel.writeString(state)
		parcel.writeString(storeID)
		parcel.writeString(longitude)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<StoresItem> {
		override fun createFromParcel(parcel: Parcel): StoresItem {
			return StoresItem(parcel)
		}

		override fun newArray(size: Int): Array<StoresItem?> {
			return arrayOfNulls(size)
		}
	}
}