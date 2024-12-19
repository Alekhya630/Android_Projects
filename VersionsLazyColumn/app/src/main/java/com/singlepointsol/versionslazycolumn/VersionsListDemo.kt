package com.singlepointsol.versionslazycolumn


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VersionsListDemo(modifier: Modifier = Modifier){
    LazyColumnDemo()
}
@Composable
fun LazyColumnDemo(){
    LazyColumn {
        itemsIndexed(items = getAllVersions(), itemContent = {index,item -> VersionItem(item = item) })
    }
}
@Composable
fun VersionItem(item: Version, modifier: Modifier = Modifier) {
    Row(
        Modifier.fillMaxWidth().padding(16.dp)
            .background(color = Color.LightGray)
            .size(96.dp).clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(id = item.versionImage),
            contentDescription = item.versionName,
            //Modifier.padding(8.dp).align(Alignment.CenterVertically)
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
        )
        Column(
            Modifier.fillMaxSize().padding(8.dp).align(Alignment.CenterVertically),
            Arrangement.Center
        ) {
            Text(
                text = item.versionName,
                style = TextStyle(
                    color = Color.Green,
                    fontSize = 22.sp,
                    fontStyle = FontStyle.Italic
                )
            )
            Text(text = item.versionDetails, style = TextStyle(color = Color.Black, fontSize = 20.sp))
        }

    }
}
