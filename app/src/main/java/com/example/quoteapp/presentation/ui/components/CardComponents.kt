package com.example.quoteapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreenCard(
content: String,
author: String,
){
    Card(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(2.dp)
    ) {
       Row(
           modifier = Modifier.fillMaxWidth().padding(16.dp),
           verticalAlignment = Alignment.CenterVertically
       ) {
           Image(
               imageVector = Icons.Filled.Info,
               contentDescription = "quote item",
               colorFilter = ColorFilter.tint(Color.White),
               modifier = Modifier
                   .size(40.dp)
                   .background(Color.Black)

           )
           Spacer(modifier = Modifier.padding(8.dp))
           Column(
               modifier = Modifier.weight(1f)
           ) {
               Text(
                   text = content,
                   style = TextStyle(
                       fontWeight = FontWeight.Normal,
                       fontFamily = FontFamily.SansSerif
                   ),
                   fontSize = 18.sp
               )
               Text(
                   text = author,
                   style = TextStyle(
                       fontWeight = FontWeight.Medium,
                       fontFamily = FontFamily.SansSerif
                   ),
                   fontSize = 18.sp
               )
           }
       } 
    }
}