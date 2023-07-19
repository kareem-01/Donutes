package com.example.dounats.screens.splashSCreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.dounats.R
import com.example.dounats.Screens
import com.example.dounats.ui.theme.black
import com.example.dounats.ui.theme.bodyLarge
import com.example.dounats.ui.theme.getStarted
import com.example.dounats.ui.theme.labelLarge
import com.example.dounats.ui.theme.pinkBackGround
import com.example.dounats.ui.theme.primaryColor
import com.example.dounats.ui.theme.secondaryColor
import com.example.dounats.ui.theme.splashBody
import com.example.dounats.ui.theme.splashTitle
import com.example.dounats.ui.theme.titleXLarge
import com.example.dounats.ui.theme.white

@Composable
fun SplashScreen(navController: NavHostController) {
    SplashContent {
        navController.navigate(Screens.homeScreen.route)
    }
}

@Composable
fun SplashContent(onStartedClick: () -> Unit) {
    val scroll = rememberScrollState()
    Box(
        modifier = Modifier
            .scrollable(state = scroll, orientation = Orientation.Vertical)
            .fillMaxSize()
            .background(color = pinkBackGround)
    ) {
        ConstraintLayout(modifier = Modifier) {
            val (
                donuts,
                blueDonut,
                pinkDonut,
                tinyDonut,
                halfDonut,
                title,
                body,
                startButton,
            ) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.blue_donut), contentDescription = null,
                modifier = Modifier
                    .size(186.dp)
                    .constrainAs(blueDonut) {
                        top.linkTo(parent.top, margin = (-11).dp)
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.pink_donut),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .constrainAs(pinkDonut) {
                        top.linkTo(parent.top, margin = 30.dp)
                        end.linkTo(parent.end, margin = 20.dp)
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.splash_donuts),
                contentDescription = null,
                modifier = Modifier
                    .width(1000.dp)
                    .height(600.dp)
                    .constrainAs(donuts) {
                        top.linkTo(parent.top, margin = -15.dp)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.tiny_donut),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .constrainAs(tinyDonut) {
                        top.linkTo(donuts.bottom, margin = (-310).dp)
                        start.linkTo(parent.start, margin = 30.dp)
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.half_donut),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .constrainAs(halfDonut) {
                        top.linkTo(donuts.top, margin = 400.dp)
                        end.linkTo(parent.end, margin = (-25).dp)
                    }
            )
            Text(
                text = splashTitle,
                color = primaryColor,
                style = titleXLarge,
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .constrainAs(title) {
                        start.linkTo(parent.start, margin = 40.dp)
                        top.linkTo(halfDonut.top, margin = 50.dp)
                    },
            )
            Text(
                text = splashBody,
                style = bodyLarge,
                color = secondaryColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .constrainAs(body) {
                        top.linkTo(title.bottom)
                    }
            )
            Button(
                onClick = onStartedClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .height(60.dp)
                    .constrainAs(startButton) {
                        bottom.linkTo(parent.bottom, margin = -80.dp)
                    },
                colors = ButtonDefaults.buttonColors(containerColor = white)
            ) {
                Text(text = getStarted, color = black, style = labelLarge)
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SplashContent({})
}