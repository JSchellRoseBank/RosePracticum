package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.MainActivity
import com.example.myapplication.ui.theme.MyApplicationTheme

class DetailedViewScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 30.dp, top = 60.dp, end = 30.dp)
                ) {
                    Button(onClick = {}) {
                        Text(text = "Show Playlist")
                    }

                    Button(onClick = {}) {
                        Text(text = "Show average Rating for playlist")
                    }

                    Button(onClick = {
                        val next = Intent(this@DetailedViewScreen, MainActivity::class.java);
                        startActivity(next)
                    }) {
                        Text(text = "Back")
                    }
                }
            }
        }
    }
}

