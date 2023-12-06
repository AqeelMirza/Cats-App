package com.cats_app.domain.repository

import com.cats_app.domain.CatsApi
import com.cats_app.domain.data.Cat
import javax.inject.Inject

class CatsRepo @Inject constructor(
    private val api: CatsApi
) {
    suspend fun getCats(): List<Cat> {
        return api.getAllCats()
    }

    suspend fun addCat(cat: Cat) {
        return api.addCat(cat)
    }
}