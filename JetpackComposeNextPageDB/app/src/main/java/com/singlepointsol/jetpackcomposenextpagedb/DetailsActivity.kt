package com.singlepointsol.jetpackcomposenextpagedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: "N/A"
        val favouriteFood = intent.getStringExtra("favouriteFood") ?: "N/A"
        val favouriteColor = intent.getStringExtra("favouriteColor") ?: "N/A"

        setContent {
            UserDetailsScreen(name, favouriteFood, favouriteColor)
        }
    }
}

@Composable
fun UserDetailsScreen(name: String, favouriteFood: String, favouriteColor: String) {
    val userDetails = listOf(
        "User Details",
        "Name: $name",
        "Favourite Food: $favouriteFood",
        "Favourite Color: $favouriteColor"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(userDetails) { detail ->
            Text(text = detail, style = if (detail == "User Details") androidx.compose.ui.text.TextStyle(fontSize = 24.sp) else androidx.compose.ui.text.TextStyle())
        }
    }
}
