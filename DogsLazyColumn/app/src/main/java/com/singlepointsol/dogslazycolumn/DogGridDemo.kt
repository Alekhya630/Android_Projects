package com.singlepointsol.dogslazycolumn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items // Import for items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//with images and name ,details
@Composable
fun DogGridDemo() {
    Column {
        Text(
            text = "LazyVerticalGrid",
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(8.dp)
        )

        LazyVerticalGridDemo()

        Text(
            text = "LazyHorizontalGrid",
            style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(8.dp)
        )

        LazyHorizontalGridDemo()
    }
}

@Composable
fun LazyVerticalGridDemo() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Two columns in the vertical grid
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getAllDogImages().size) { index -> // Fixed typo here
            DogItem(item = getAllDogImages()[index])
        }
    }
}

@Composable
fun LazyHorizontalGridDemo() {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2), // Two rows in the horizontal grid
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getAllDogImages().size) { index ->
            DogItem(item = getAllDogImages()[index])
        }
    }
}

@Composable
fun DogItem(item: Dog, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = item.dogImage),
                contentDescription = item.dogBreed,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = item.dogBreed,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = item.dogDetails,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}

/*
@Composable
fun DogGridDemo() {
    Column {
        LazyVerticalGridDemo()

        LazyHorizontalGridDemo()
    }
}

@Composable
fun LazyVerticalGridDemo() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4), // Two columns in the vertical grid
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getAllDogImages().size) { index ->
            DogItem(item = getAllDogImages()[index])
        }
    }
}

@Composable
fun LazyHorizontalGridDemo() {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(4), // Two rows in the horizontal grid
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getAllDogImages().size) { index ->
            DogItem(item = getAllDogImages()[index])
        }
    }
}

 */

/*
//For only images
@Composable
fun DogItem(item: Dog, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = item.dogImage),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

 */


/*
//image and text below the image
@Composable
fun DogItem(item: Dog, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Center image and text
        ) {
            // Image at the top
            Image(
                painter = painterResource(id = item.dogImage),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )

            // Dog breed name below the image
            Text(
                text = item.dogBreed,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 8.dp) // Add space between image and text
            )

            // Dog details below the breed name
            Text(
                text = item.dogDetails,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 4.dp) // Add space between breed and details
            )
        }
    }
}


 */


