package com.cats_app.cats

import com.cats_app.domain.data.Cat

data class CatState(
    val isLoading: Boolean = false,
    val catsList: List<Cat> = emptyList(),
    val isError: Boolean = false
)
