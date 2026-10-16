package com.nusadataindonesia.pertemuan_kelima_advance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun page(modifier: Modifier){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = null,
            modifier=modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(top = 300.dp)
                .fillMaxSize(1f)
                .background(color = Color.White,
                        shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)),
        ) {
            ElevatedCard(
            ) {

            }
        }
    }
}