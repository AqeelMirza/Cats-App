package com.cats_app.cats

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cats_app.domain.CatsApi
import com.cats_app.domain.data.Cat
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val api: CatsApi
) : ViewModel() {

    private val _state = mutableStateOf(CatState())
    val state: State<CatState> = _state

    init {
        getAllCats()
    }

    private fun getAllCats() {
        viewModelScope.launch {
            runCatching {
                _state.value = state.value.copy(isLoading = true, isError = false)
                api.getAllCats()
            }.onSuccess { catsList ->
                _state.value =
                    state.value.copy(catsList = catsList, isLoading = false, isError = false)
            }.onFailure {
                _state.value = state.value.copy(isError = true, isLoading = false)
            }
        }
    }

    fun addCat(cat: Cat) {
        viewModelScope.launch {
            runCatching {
                _state.value = state.value.copy(isLoading = true, isError = false)
                api.addCat(cat)
            }.onSuccess {
                getAllCats()
            }.onFailure {
                Log.e("error", it.stackTraceToString())
                _state.value = state.value.copy(isLoading = false, isError = true)
            }
        }
    }


}