package com.cats_app.cats.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cats_app.domain.data.Cat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewCat(addCat: (Cat) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            value = "new cat",
            onValueChange = { },
            label = { Text("Cat Name") }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = { },
            label = { Text("Cat Description") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            value = "",
            onValueChange = { },
            label = { Text("Cat Image") }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(),
            onClick = {
                // TODO - addCat logic
            }
        ) {
            Text(
                text = "Submit",
                color = Color.White
            )
        }

    }
}