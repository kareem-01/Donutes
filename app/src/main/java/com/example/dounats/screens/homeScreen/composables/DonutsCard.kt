package com.example.dounats.screens.homeScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.dounats.R
import com.example.dounats.ui.theme.ChocoCherry
import com.example.dounats.ui.theme.StrawRain
import com.example.dounats.ui.theme.StrawberryText
import com.example.dounats.ui.theme.black60
import com.example.dounats.ui.theme.bodySmall
import com.example.dounats.ui.theme.labelXSmall
import com.example.dounats.ui.theme.white

@Composable
fun DonutsCard(index: Int, onItemClick: () -> Unit) {
    ConstraintLayout(modifier = Modifier.height(170.dp)) {
        val (donut, card) = createRefs()
        Card(
            modifier = Modifier
                .height(111.dp)
                .width(138.dp)
                .constrainAs(card) {
                    bottom.linkTo(parent.bottom)
                }
                .clickable { onItemClick() },
            colors = CardDefaults.cardColors(containerColor = white),
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomStart = 10.dp,
                bottomEnd = 10.dp
            ),
            elevation = CardDefaults.cardElevation(0.dp),

            ) {
            Text(
                text = when (index) {
                    0 -> ChocoCherry
                    1 -> StrawRain
                    else -> StrawberryText
                },
                style = labelXSmall,
                color = black60,
                modifier = Modifier
                    .padding(top = 40.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "$22",
                color = black60,
                style = bodySmall,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            )
        }
        Image(
            painter = painterResource(
                id = when (index) {
                    0 -> R.drawable.donut1
                    1 -> R.drawable.donut2
                    else -> R.drawable.donut3
                }
            ), contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .constrainAs(donut) {
                    centerHorizontallyTo(parent)
                    top.linkTo(parent.top, margin = 7.dp)
                }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    DonutsCard(0,{})
}