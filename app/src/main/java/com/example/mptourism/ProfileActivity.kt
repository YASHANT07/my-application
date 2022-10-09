package com.example.mptourism

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.mptourism.data.Tourism
import com.example.mptourism.ui.theme.MpTourismTheme

class ProfileActivity : AppCompatActivity() {

    private val tourism: Tourism by lazy{
        intent?.getSerializableExtra(TOURISM_ID) as Tourism
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MpTourismTheme{
                ProfileScreen(tourism = tourism)
            }
        }
    }
    companion object {
        private const val TOURISM_ID ="puppy_id"
        fun newIntent(context: Context, tourism: Tourism) =
            Intent(context,ProfileActivity::class.java).apply {
                putExtra( TOURISM_ID, tourism)
            }
    }

}