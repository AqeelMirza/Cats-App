package com.cats_app.cats

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cats_app.domain.data.Cat
import com.cats_app.domain.data.ImageDataSource
import com.cats_app.domain.repository.CatsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val repo: CatsRepo
) : ViewModel() {

    private val _state = mutableStateOf(CatState())
    val state: State<CatState> = _state

    private val _addCatState = mutableStateOf(AddCatState())
    val addCatState: State<AddCatState> = _addCatState

    fun getAllCats() {
        viewModelScope.launch {
            _addCatState.value = AddCatState()
            runCatching {
                _state.value = state.value.copy(isLoading = true, isError = false)
                repo.getCats()
            }.onSuccess { catsList ->
                val images = ImageDataSource.images
                catsList.forEach {
                    it.image = images.random().toString()
                }
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
                _addCatState.value = addCatState.value.copy(isLoading = true, isError = false)
                repo.addCat(cat)
            }.onSuccess {
                _addCatState.value = addCatState.value.copy(isLoading = false, isSuccess = true)
            }.onFailure {
                Log.e("error", it.stackTraceToString())
                _addCatState.value = addCatState.value.copy(isLoading = false, isError = true)
            }
        }
    }
}