package com.example.storedy.api

import com.squareup.moshi.Json

data class Response(

	@Json(name="stores")
	val stores: List<StoresItem?>? = null
)