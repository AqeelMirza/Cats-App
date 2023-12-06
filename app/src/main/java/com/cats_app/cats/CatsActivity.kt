package com.cats_app.cats

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.cats_app.cats.compose.CatPage
import com.cats_app.ui.theme.CatsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatsAppTheme {
                val viewModel: CatsViewModel = hiltViewModel()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when {
                        viewModel.state.value.isError -> {
                            CatPage(catsList = viewModel.state.value.catsList)
                            Toast.makeText(this, "some error", Toast.LENGTH_SHORT).show()
                        }

                        viewModel.state.value.isLoading -> {
                            CircularProgressIndicator()
                        }

                        viewModel.state.value.catsList.isEmpty() -> {
                            CatPage(catsList = viewModel.state.value.catsList)
                        }

                        viewModel.state.value.catsList.isNotEmpty() -> {
                            CatPage(
                                catsList = viewModel.state.value.catsList,
                                addCat = viewModel::addCat
                            )
                        }

                    }
                }
            }
        }
    }
}