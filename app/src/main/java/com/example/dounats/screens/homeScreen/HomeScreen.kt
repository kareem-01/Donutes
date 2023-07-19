package com.example.dounats.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dounats.R
import com.example.dounats.Screens
import com.example.dounats.screens.homeScreen.composables.DonutsCard
import com.example.dounats.screens.homeScreen.composables.OffersCard
import com.example.dounats.ui.theme.Donuts
import com.example.dounats.ui.theme.black60
import com.example.dounats.ui.theme.bodyMedium
import com.example.dounats.ui.theme.homeTitle
import com.example.dounats.ui.theme.labelLarge
import com.example.dounats.ui.theme.offersText
import com.example.dounats.ui.theme.orderDonutsText
import com.example.dounats.ui.theme.pinkBackGround
import com.example.dounats.ui.theme.primaryColor
import com.example.dounats.ui.theme.titleLarge
import com.example.dounats.ui.theme.white

@Composable
fun HomeScreen(navController: NavHostController) {
    HomeContent(
        onItemClick = {
            navController.navigate(Screens.orderScreen.route)
        }
    )
}

@Composable
fun HomeContent(onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = white)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = homeTitle,
                color = primaryColor,
                style = titleLarge
            )

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(color = pinkBackGround)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    modifier = Modifier.padding(6.dp)
                )

            }
        }
        Text(
            text = orderDonutsText,
            color = black60,
            style = bodyMedium,
            modifier = Modifier.padding(start = 24.dp, bottom = 25.dp)
        )
        Text(
            text = offersText,
            modifier = Modifier.padding(start = 24.dp, top = 24.dp, bottom = 24.dp),
            style = labelLarge
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(2) { index ->
                OffersCard(index = index, onItemClick = onItemClick)
            }
        }
        Text(
            text = Donuts,
            style = labelLarge,
            modifier = Modifier.padding(start = 24.dp, top = 32.dp),
        )
        LazyRow(
            contentPadding = PaddingValues(24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(3) { index ->
                DonutsCard(index = index, onItemClick)
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    HomeScreen(rememberNavController())
}