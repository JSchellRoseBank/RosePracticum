package com.example.practicalimad

import android.R.attr.text
import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalimad.ui.theme.PracticalIMADTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var song by remember { mutableStateOf("") }
            var artist by remember { mutableStateOf("") }
            var ratings by remember { mutableStateOf("") }
            var comments by remember { mutableStateOf("") }
            var showOptions by remember { mutableStateOf(false) }

            PracticalIMADTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 30.dp, top = 60.dp, end = 30.dp)
                ){
                    Text(text="testing")
                    Row {
                        Button(onClick = {
                            showOptions = true
                        }) { Text(text = "Add To Playlist") }

                    }
                    Row {
                        if(showOptions) {
                            Column {
                                OutlinedTextField(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(12.dp))
                                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp)),
                                    textStyle = TextStyle(color = Color.Black),
                                    value = song,
                                    onValueChange = {
                                            text -> song = text
                                    },
                                    placeholder = {
                                        Text(text="Enter Song's Name")
                                    },
                                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(12.dp))
                                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp)),
                                    textStyle = TextStyle(color = Color.Black),
                                    value = artist,
                                    onValueChange = {
                                            text -> artist = text
                                    },
                                    placeholder = {
                                        Text(text="Enter Artist's Name")
                                    },
                                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(12.dp))
                                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp)),
                                    textStyle = TextStyle(color = Color.Black),
                                    value = ratings,
                                    onValueChange = {
                                            text -> ratings = text
                                    },
                                    placeholder = {
                                        Text(text="Enter Rating 1-5")
                                    },
                                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
                                )
                                OutlinedTextField(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(12.dp))
                                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp)),
                                    textStyle = TextStyle(color = Color.Black),
                                    value = comments,
                                    onValueChange = {
                                            text -> comments = text
                                    },
                                    placeholder = {
                                        Text(text="Enter Song's Name")
                                    },
                                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}

