package com.example.mptourism

import androidx.compose.foundation.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mptourism.data.Tourism
import androidx.compose.material.Card
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
fun TourismListItem(tourism: Tourism, navigateToProfile: (Tourism)-> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp,)
            .fillMaxWidth(),
        elevation = 2.dp,

        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {


        Row(
            Modifier.clickable { navigateToProfile(tourism) }
        ) {
            TourismImage(tourism = tourism)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = tourism.title, style = typography.h6)

                Text(text = "VISIT TOURIST SPOT", style = typography.caption)
            }
        }
    }
}
@Composable
private fun TourismImage(tourism: Tourism) {
    Image(
        painter = painterResource(id = tourism.tourismImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

