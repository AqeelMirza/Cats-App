package com.cats_app.domain

import com.cats_app.domain.data.Cat
import retrofit2.http.GET

interface CatsApi {


    companion object {
        //const val BASE_URL = "http://localhost:8080"
        const val BASE_URL = "http://10.0.2.2:8080/"
    }

    @GET("allCats")
    suspend fun getAllCats(): List<Cat>

}