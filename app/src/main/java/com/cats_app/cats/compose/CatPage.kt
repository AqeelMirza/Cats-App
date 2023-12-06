package com.cats_app.cats.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cats_app.R
import com.cats_app.domain.data.Cat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatPage(
    catsList: List<Cat>,
    addCat: ((Cat) -> Unit)? = null
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
            if (catsList.isEmpty()) {
                EmptyPage()
            } else {
                DisplayCats(catsList)
            }

        }
    })
}

@Composable
fun EmptyPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.empty_list),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.add_new_cat),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
private fun DisplayCats(catsList: List<Cat>) {
    val cats =
        listOf(R.drawable.cat1, R.drawable.cat2)
    LazyColumn {
        itemsIndexed(catsList) { index, cat ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .padding(16.dp)
            ) {
                Image(
                    modifier = Modifier.weight(1F),
                    painter = painterResource(id = cats.random()), contentDescription = null
                )

                Text(
                    modifier = Modifier
                        .weight(3F),
                    text = cat.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black
                    //color = Color(98, 20, 236, 255)
                )
            }
            Divider(
                modifier = Modifier
                    .height(2.dp)
                    .background(Color(134, 99, 194, 255))
            )
        }
    }
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