package com.example.mptourism

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import com.example.mptourism.data.Tourism
import androidx.compose.material.Surface

@Composable
fun ProfileScreen(tourism: Tourism){
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxWidth()){
        BoxWithConstraints {
            Surface() {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                ){


                    profileHeader(tourism = tourism, containerHeight = this@BoxWithConstraints.maxHeight)
                    ProfileContent(tourism = tourism, containerHeight = this@BoxWithConstraints.maxHeight)

                }

            }

        }
    }
}
@Composable
private fun profileHeader(
    tourism: Tourism,
    containerHeight: Dp

){
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = tourism.tourismImageId) ,
                contentScale = ContentScale.Crop,
                contentDescription = null
    )
}
@Composable
private fun ProfileContent(tourism: Tourism, containerHeight: Dp){
    Column{
        Title(tourism = tourism)
        ProfileProperty(label = stringResource(id = R.string.title), value = tourism.title)
        ProfileProperty(label = stringResource(id = R.string.description), value = tourism.description)

        Spacer(modifier = Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))

    }
    }


@Composable
private fun Title(tourism: Tourism){
    Column(modifier = Modifier.padding( 16.dp, )){
        Text(
            text = tourism.title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }

}
@Composable
private fun ProfileProperty(label:String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)){
    Divider(modifier = Modifier.padding(bottom = 4.dp))
    Text(
        text = label,
        modifier = Modifier.height(24.dp) ,
                style = MaterialTheme.typography .caption

    )
    Text(
        text = value,
        modifier = Modifier.height(24.dp),
        style = MaterialTheme.typography.body1,
        overflow = TextOverflow.Visible
    )
}
}