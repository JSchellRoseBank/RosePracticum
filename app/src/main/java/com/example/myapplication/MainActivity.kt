package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.DetailedViewScreen
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val context = LocalContext.current

                var song by remember { mutableStateOf("") }
                var artist by remember { mutableStateOf("") }
                var ratings by remember { mutableStateOf("") }
                var comments by remember { mutableStateOf("") }
                var showOptions by remember { mutableStateOf(false) }
                var newPage by remember { mutableStateOf(false) }
                var showPlaylist by remember { mutableStateOf(false) }
                var showRatingAverage by remember { mutableStateOf(false) }
                var averageRating by remember { mutableStateOf(0.0) }

                var songList = remember {mutableStateListOf<String>()}
                var artistList = remember {mutableStateListOf<String>()}
                var ratingList = remember {mutableStateListOf<String>()}
                var commentList = remember {mutableStateListOf<String>()}


                if(!newPage) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 30.dp, top = 60.dp, end = 30.dp)
                    ){
                        Row {
                            Button(onClick = {
                                showOptions = true
                            }) { Text(text = "Add To Playlist") }

                        }
                        Row {
                            if(showOptions) {
                                Column {
                                    Spacer(modifier = Modifier.size(30.dp))
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

                                    Spacer(modifier = Modifier.size(20.dp))

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

                                    Spacer(modifier = Modifier.size(20.dp))

                                    OutlinedTextField(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(12.dp))
                                            .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp)),
                                        textStyle = TextStyle(color = Color.Black),
                                        value = ratings,
                                        onValueChange = {
                                                number -> ratings = number
                                        },
                                        placeholder = {
                                            Text(text="Enter Rating 1-5")
                                        },
                                        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
                                    )

                                    Spacer(modifier = Modifier.size(20.dp))

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
                                            Text(text="Comments")
                                        },
                                        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)
                                    )
                                    Spacer(modifier = Modifier.size(20.dp))

                                    Button(onClick = {
                                        songList.add(song)
                                        artistList.add(artist)
                                        ratingList.add(ratings)
                                        commentList.add(comments)

                                        song = ""
                                        artist = ""
                                        ratings = ""
                                        comments = ""
                                    }) {
                                        Text(text = "Add")
                                    }
                                    Spacer(modifier = Modifier.size(30.dp))
                                }

                            }
                        }
                        Row {
                            Button(onClick = {
                                newPage = true
                            })
                            { Text(text = "Continue to Detailed View") }
                        }

                        Row {
                            Button(onClick = {
                                (context as? Activity)?.finishAffinity()
                            })
                            { Text(text = "Exit") }
                        }
                    }
                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 30.dp, top = 60.dp, end = 30.dp)
                    ) {
                        Button(onClick = {
                            showPlaylist = true
                        }) {
                            Text(text = "Show Playlist")
                        }

                        if(showPlaylist) {
                            ShowPlaylist(songList, artistList, ratingList, commentList)
                        }

                        Button(onClick = {
                            showRatingAverage = true
                        }) {
                            Text(text = "Show average Rating for playlist")
                        }

                        if(showRatingAverage) {
                            var totalRating = 0.0
                            var validRatingCount = 0

                            for(i in ratingList.indices) {
                                val ratingss = ratingList[i].toDoubleOrNull()
                                if(ratingss != null && ratingss in 1.0..5.0) {
                                    totalRating += ratingss
                                    validRatingCount++
                                }
                            }

                            averageRating = if (validRatingCount > 0) {
                                totalRating / validRatingCount
                            } else {
                                0.0
                            }

                            Text(text = "Your average rateing is: $averageRating")
                        }

                        Button(onClick = {
                            newPage = false
                            showRatingAverage = false
                            showPlaylist = false
                        }) {
                            Text(text = "Back")
                        }

                    }
                }

                }
            }
        }
    }

@Composable
fun ShowPlaylist(songList: MutableList<String>, artistList: MutableList<String>, ratingList: MutableList<String>, commentList: MutableList<String>) {
    Column(modifier = Modifier.padding(5.dp)) {
        songList.zip(artistList).forEachIndexed { index, (song, artist) ->
            Column(modifier = Modifier.padding(top = 15.dp)) {
                Text(text = "$song, $artist")
            }
        }
    }
}
