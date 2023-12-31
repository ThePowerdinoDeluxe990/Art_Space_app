package com.example.artspaceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainApp(){

    var number by remember {
        mutableIntStateOf(0)
    }

    val artImage = when(number){
        0 -> R.drawable.minecarftwallpaper
        1 -> R.drawable.homerbarsa
        else -> R.drawable.freddyfazbear
    }

    val artTitle = when(number){
        0 -> R.string.artwork_title1
        1 -> R.string.artwork_title2
        else -> R.string.artwork_title3
    }

    val artDescription = when(number){
        0 -> R.string.artwork_description1
        1 -> R.string.artwork_description2
        else -> R.string.artwork_description3
    }

    val moreInfo = when(number){
        0 -> R.string.moreinfo1
        1 -> R.string.moreinfo2
        else -> R.string.moreinfo3
    }
    Scaffold(
        bottomBar = {
            ButtonsSelectors(
                number,
                onDecrement = {
                    if(number == 0){
                        number =0
                    }else{
                        number--
                    }
                },

                onIncrement = {
                    if(number == 2){
                        number = 2
                    }else{
                        number++
                    }
                }

            )
        },
    ) {
        Column (
            Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(30.dp) )

            ArtShower( artImage,artTitle,artDescription,moreInfo)

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpaceArtPreview(){
    MainApp()
}