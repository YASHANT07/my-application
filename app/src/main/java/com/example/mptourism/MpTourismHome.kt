package com.example.mptourism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.mptourism.data.DataGeter
import com.example.mptourism.data.Tourism


@Composable
fun MpTourismHomeContent(navigateToProfile: (Tourism) -> Unit) {
    val tourism= remember { DataGeter.tourismList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = tourism,
            itemContent = {
                TourismListItem(tourism = it, navigateToProfile)
            }
        )
    }
}