package com.cats_app.domain.data

import kotlinx.serialization.Serializable

@Serializable
data class Cat(val id: String? = null, val name: String, var image: String, val description: String)