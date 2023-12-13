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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cats_app.R
import com.cats_app.cats.CatsViewModel
import com.cats_app.domain.data.Cat

@Composable
fun CatStartPage(viewModel: CatsViewModel) {
    LaunchedEffect(Unit) {
        viewModel.getAllCats()
    }

    when {
        viewModel.state.value.isError -> {
            EmptyPage()
        }

        viewModel.state.value.isLoading -> {
            CircularProgressIndicator()
        }

        else -> {
            DisplayCats(catsList = viewModel.state.value.catsList)
        }
    }
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
    LazyColumn {
        items(catsList) { cat ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(intrinsicSize = IntrinsicSize.Max),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Image(
                    modifier = Modifier.size(65.dp),
                    painter = painterResource(id = cat.image.toInt()), contentDescription = null
                )

                Text(
                    modifier = Modifier.align(CenterVertically),
                    text = cat.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black
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
        Icon(Icons.Filled.Add, null)
    }
}