package com.example.mptourism

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mptourism.data.Tourism
import com.example.mptourism.ui.theme.MpTourismTheme
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MpTourismTheme {
               MyApp {
                   startActivity(ProfileActivity.newIntent(this, it))
               }
            }
        }
    }
}


@Composable
fun MyApp(navigationToProfile: (Tourism)-> Unit) {
    Scaffold(
        content = {

            MpTourismHomeContent(navigateToProfile = navigationToProfile)
        }
            )
}

