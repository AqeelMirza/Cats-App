package com.cats_app.cats.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewCat() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(), text = "Cats", color = Color.White
                )
            }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color(103, 58, 183, 255)
            )
        )
    }, content = { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            OutlinedTextField(
                value = "cat",
                onValueChange = { },
                label = { Text("Cat Name") }
            )

            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = { Text("Cat Description") }
            )

            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = { Text("Cat Image") }
            )


        }
    })
}