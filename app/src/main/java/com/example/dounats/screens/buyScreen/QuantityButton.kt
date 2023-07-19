package com.example.dounats.screens.buyScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dounats.ui.theme.black
import com.example.dounats.ui.theme.titleLarge
import com.example.dounats.ui.theme.white

@Composable
fun QuantityButton(modifier: Modifier = Modifier, item: String, color: Color = black) {
    Box(
        modifier = modifier
            .size(45.dp)
            .background(
                color = if (color == black) white else black,
                shape = RoundedCornerShape(15.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item,
            color = color,
            style = titleLarge,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Preview
@Composable
private fun Preview() {
    QuantityButton(item = "1", color = white)
}