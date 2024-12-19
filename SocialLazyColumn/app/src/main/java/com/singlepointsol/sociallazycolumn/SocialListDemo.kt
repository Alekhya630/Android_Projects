package com.singlepointsol.sociallazycolumn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun SocialListDemo(modifier: Modifier = Modifier) {
    LazyColumnDemo()
}

@Composable
fun LazyColumnDemo() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(
            items = getAllSocialImages(),
            itemContent = { index, item ->
                SocialItem(item = item)
            }
        )
    }
}

@Composable
fun SocialItem(item: Social, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), // Padding outside the card
        //shape = RoundedCornerShape(16.dp), // Rounded corners for the card
        elevation = CardDefaults.cardElevation(6.dp) // Shadow elevation
    )
    {
        Row(
            modifier = Modifier
                .padding(16.dp) // Padding inside the card for the Row contents
        ) {
            // Image with  clipping
            Image(
                painter = painterResource(id = item.socialImage),
                contentDescription = item.socialName,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp) // Space between image and text
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                //  name styled as a bold
                Text(
                    text = item.socialName,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                // details  with a small font
                Text(
                    text = item.socialDetails,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}
