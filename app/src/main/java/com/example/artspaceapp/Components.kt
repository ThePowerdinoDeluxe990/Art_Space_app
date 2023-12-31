package com.example.artspaceapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ImageArtShower(
    @DrawableRes ImageArt: Int,
    @StringRes DescriptionArt:Int
    )
{
    Column {
        Image(
            modifier = Modifier
                .defaultMinSize(minHeight = 200.dp, minWidth = 100.dp)
                .width(300.dp)
                .height(500.dp)
                .shadow(20.dp)
                .border(BorderStroke(30.dp, Color(0xFFFFFFFF))),

            contentScale = ContentScale.FillBounds,
            painter = painterResource(ImageArt),
            contentDescription = stringResource(DescriptionArt)
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextArt(
    @StringRes TitleArt:Int,
    @StringRes DescriptionArt:Int,
    @StringRes MoreInfo:Int
){
    var SwitchOf by remember {
        mutableStateOf(false)
    }

    Column (
        Modifier
            .width(300.dp)
            .shadow(4.dp)
            .background(Color(0xffecebf4))

            .combinedClickable(
                onClick = { /* Nothing LOL */ },
                onLongClick = {
                    SwitchOf = SwitchOf == false
                }
            ),
    ){

        Text(
            stringResource(TitleArt),
            fontSize = 35.sp,
            color = Color.Black,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(10.dp)
        )

        Text(
            stringResource(DescriptionArt),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 10.dp)
        )

        if (SwitchOf == true){
            Text(
                stringResource(MoreInfo),
                color = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp,15.dp
                    )
            )

            Text(
                stringResource(R.string.showless),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }else{
            Text("")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewElements(){
    Column {
        ImageArtShower(
            ImageArt = R.drawable.minecarftwallpaper,
            DescriptionArt = R.string.artwork_description1
        )

        TextArt(
            TitleArt = R.string.artwork_title1,
            DescriptionArt = R.string.artwork_description1,
            MoreInfo = R.string.moreinfo1
        )

    }
}
