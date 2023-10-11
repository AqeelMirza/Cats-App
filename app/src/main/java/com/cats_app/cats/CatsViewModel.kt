package com.cats_app.cats

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cats_app.domain.CatsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val api: CatsApi
) : ViewModel() {

    init {
        getAllCats()
    }

    private var _state by mutableStateOf(CatState())
    val state: CatState = _state


    private fun getAllCats() {
        viewModelScope.launch {
            _state = state.copy(isLoading = true)
            runCatching {
                api.getAllCats()
            }.onSuccess { catsList ->
                _state = state.copy(catsList = catsList, isLoading = false)
            }.onFailure {
                _state = state.copy(isError = true, isLoading = false)
            }
        }
    }


}