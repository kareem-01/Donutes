package com.example.dounats.screens.buyScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dounats.R
import com.example.dounats.ui.theme.DonutDetails
import com.example.dounats.ui.theme.Donuts
import com.example.dounats.ui.theme.black60
import com.example.dounats.ui.theme.bodyMedium
import com.example.dounats.ui.theme.cardBackGround
import com.example.dounats.ui.theme.labelLarge
import com.example.dounats.ui.theme.labelMedium
import com.example.dounats.ui.theme.lightPink
import com.example.dounats.ui.theme.primaryColor
import com.example.dounats.ui.theme.strawberry
import com.example.dounats.ui.theme.titleLarge
import com.example.dounats.ui.theme.white

@Composable
fun BuyScreen(navController: NavHostController) {
    BuyContent(
        name = strawberry,
        donutId = R.drawable.home_pink_donut,
        onBackClick = { navController.popBackStack() })
}

@Composable
fun BuyContent(name: String, donutId: Int, onBackClick: () -> Unit) {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .background(lightPink),
    ) {
        val (donut, favorite, card) = createRefs()

        Icon(
            painter = painterResource(id = R.drawable.back_arrow),
            contentDescription = null,
            tint = primaryColor,
            modifier = Modifier
                .padding(start = 32.dp, top = 40.dp)
                .clickable { onBackClick() }
        )
        Image(
            painter = painterResource(id = donutId),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .constrainAs(donut) {
                    bottom.linkTo(card.top, margin = 26.dp)
                    centerHorizontallyTo(parent)
                }
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.55f)
                .constrainAs(card) {
                    bottom.linkTo(parent.bottom)
                },
            colors = CardDefaults.cardColors(containerColor = cardBackGround),
            shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp)
        ) {
            Text(
                text = name,
                style = titleLarge,
                color = primaryColor,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 32.dp, start = 40.dp)
            )
            Text(
                text = "About Gonut",
                style = labelMedium,
                modifier = Modifier.padding(start = 40.dp, top = 24.dp)
            )
            Text(
                text = DonutDetails,
                style = bodyMedium,
                color = black60,
                modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 16.dp)
            )
            Text(
                text = "Quantity",
                style = labelMedium,
                modifier = Modifier.padding(start = 40.dp, top = 24.dp)
            )
            Row(
                modifier = Modifier.padding(start = 40.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                QuantityButton(item = "-")
                QuantityButton(item = "1")
                QuantityButton(item = "+", color = white)
            }
            Row(
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp, top = 32.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "£16", style = titleLarge)
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(245.dp)
                        .height(67.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor)
                ) {
                    Text(text = "Add to Cart", style = labelLarge)

                }
            }
        }


        Box(
            modifier = Modifier
                .background(color = white, shape = RoundedCornerShape(10.dp))
                .size(45.dp)
                .constrainAs(favorite) {
                    top.linkTo(card.top, margin = (-20).dp)
                    end.linkTo(card.end, margin = 35.dp)
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.favorite_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(0.dp)
                    .align(Alignment.Center)
                    .size(25.dp)
            )
        }

    }
}

@Preview
@Composable
private fun Preview() {
    BuyContent(name = strawberry, donutId = R.drawable.home_pink_donut,{})
}