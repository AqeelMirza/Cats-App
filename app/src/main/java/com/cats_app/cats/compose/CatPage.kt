package com.cats_app.cats.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cats_app.domain.data.Cat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatPage(
    catsList: List<Cat>,
    addCat: (Cat) -> Unit
) {
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
    }, floatingActionButton = {
        FloatingAddButton(onClick = {
            //Open new composable - AddCatPage()
        })
    }, content = { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn {
                itemsIndexed(catsList) { index, cat ->
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        text = cat.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                        //color = Color(98, 20, 236, 255)
                    )

                    if (index < catsList.lastIndex) {
                        Divider(
                            modifier = Modifier
                                .height(5.dp)
                                .background(Color(160, 127, 218, 255))
                        )
                    }
                }
            }
        }
    })
}

@Composable
fun FloatingAddButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
        containerColor = Color(82, 15, 201, 255),
        contentColor = Color.White
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }
}