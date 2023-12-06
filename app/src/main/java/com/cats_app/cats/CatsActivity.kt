package com.cats_app.cats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cats_app.cats.compose.CatApp
import com.cats_app.ui.theme.CatsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatsAppTheme {
                CatApp()
            }
        }
    }
}