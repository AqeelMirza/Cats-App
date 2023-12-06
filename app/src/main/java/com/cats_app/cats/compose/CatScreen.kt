@file:OptIn(ExperimentalMaterial3Api::class)

package com.cats_app.cats.compose

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cats_app.R
import com.cats_app.cats.CatsViewModel

enum class CatScreen(@StringRes val title: Int) {
    Start(title = R.string.cat_title),
    AddNewCat(title = R.string.add_cat_title),
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatApp(
    viewModel: CatsViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CatScreen.valueOf(
        backStackEntry?.destination?.route ?: CatScreen.Start.name
    )
    Scaffold(
        topBar = {
            CatAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        floatingActionButton = {
            if (currentScreen == CatScreen.Start) {
                FloatingAddButton(onClick = {
                    navController.navigate(CatScreen.AddNewCat.name)
                })
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = CatScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = CatScreen.Start.name) {
                StartScreen(viewModel)
            }
            composable(route = CatScreen.AddNewCat.name) {
                AddNewCat {}
            }

        }
    }
}

@Composable
private fun StartScreen(
    viewModel: CatsViewModel
) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when {
            viewModel.state.value.isError -> {
                CatPage(catsList = viewModel.state.value.catsList)
                Toast.makeText(context, "some error", Toast.LENGTH_SHORT).show()
            }

            viewModel.state.value.isLoading -> {
                CircularProgressIndicator()
            }

            else -> {
                CatPage(catsList = viewModel.state.value.catsList)
            }
        }
    }
}

@Composable
fun CatAppBar(
    currentScreen: CatScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(currentScreen.title), color = Color.White) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(103, 58, 183, 255)
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                        tint = Color.White
                    )
                }
            }
        }
    )
}