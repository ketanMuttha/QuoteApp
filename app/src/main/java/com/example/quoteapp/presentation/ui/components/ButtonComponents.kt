package com.example.quoteapp.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.presentation.theme.Primary
import com.example.quoteapp.presentation.theme.Secondary

@Composable
fun ButtonComponent(
    value: String,
    enabled: Boolean,
    onButtonClick: () -> Unit,
) {
    Button(
        onClick = {
            onButtonClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                shape = RoundedCornerShape(50.dp)
            ),
        enabled = enabled,
    ) {
        Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}