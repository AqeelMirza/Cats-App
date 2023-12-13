package com.cats_app.cats.compose

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cats_app.cats.CatsViewModel
import com.cats_app.domain.data.Cat


@Composable
fun AddNewCat(navController: NavHostController, viewModel: CatsViewModel, addCat: (Cat) -> Unit) {
    val context = LocalContext.current
    AddCatView(addCat)
    when {
        viewModel.addCatState.value.isLoading -> {
            CircularProgressIndicator()
        }

        viewModel.addCatState.value.isSuccess -> {
            navController.navigateUp()
            Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show()
        }

        viewModel.addCatState.value.isError -> {
            Toast.makeText(context, "Failed to add", Toast.LENGTH_SHORT).show()
        }
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun AddCatView(addCat: (Cat) -> Unit) {
    var name by remember { mutableStateOf("Cat Name") }
    var desc by remember { mutableStateOf("Cat Desc") }

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
            value = name,
            onValueChange = { name = it },
            isError = name.isEmpty(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            label = { Text("Cat Name") }
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            value = desc,
            isError = desc.isEmpty(),
            onValueChange = { desc = it },
            label = { Text("Cat Description") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(),
            onClick = {
                if (name.isNotEmpty() && desc.isNotEmpty())
                    addCat(Cat(name = name, description = desc, image = ""))
            }
        ) {
            Text(
                text = "Submit",
                color = Color.White
            )
        }
    }
}