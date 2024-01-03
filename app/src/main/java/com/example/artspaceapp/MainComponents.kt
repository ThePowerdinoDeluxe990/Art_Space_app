package com.example.artspaceapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonsSelectors(count: Int, onIncrement: () -> Unit, onDecrement: () -> Unit){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    )
    {
        Button(
            onClick = onDecrement,
            modifier = Modifier.size(width = 150.dp, height = 40.dp),

        ){
            Text("Previous")
        }

        Button(
            onClick = onIncrement ,
            modifier = Modifier.size(width = 150.dp, height = 40.dp)
        ){
            Text("Next")

        }
    }
}



@Composable
fun ArtShower(
    @DrawableRes ImageArt:Int,
    @StringRes TitleArt:Int,
    @StringRes DescriptionArt:Int,
    @StringRes MoreInfo:Int
) {
        Column {
            ImageArtShower(ImageArt = ImageArt, DescriptionArt = DescriptionArt)

            Spacer(modifier = Modifier.height(30.dp))

            TextArt(TitleArt = TitleArt, DescriptionArt = DescriptionArt, MoreInfo = MoreInfo)
        }
}