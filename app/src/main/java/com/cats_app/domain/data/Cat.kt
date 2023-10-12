package com.cats_app.domain.data

import kotlinx.serialization.Serializable

@Serializable
data class Cat(val id: String, val name: String, val image: String, val description: String)