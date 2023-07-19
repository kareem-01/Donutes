package com.example.dounats.screens.homeScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.dounats.R
import com.example.dounats.ui.theme.black
import com.example.dounats.ui.theme.black60
import com.example.dounats.ui.theme.blueBackground
import com.example.dounats.ui.theme.bodySmall
import com.example.dounats.ui.theme.bodytext
import com.example.dounats.ui.theme.labelLarge
import com.example.dounats.ui.theme.labelSmall
import com.example.dounats.ui.theme.pinkBackGround
import com.example.dounats.ui.theme.primaryColor
import com.example.dounats.ui.theme.strawberry
import com.example.dounats.ui.theme.white

@Composable
fun OffersCard(
    donutImageId: Int = R.drawable.home_pink_donut,
    title: String = strawberry,
    bodyText: String = bodytext,
    index: Int,
    onItemClick:()->Unit,

) {
    Box(modifier = Modifier.width(210.dp)) {
        ConstraintLayout(Modifier.height(300.dp)) {
            val (card, donut) = createRefs()
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(175.dp)
                    .constrainAs(card) {
                        start.linkTo(parent.start)
                    }
                    .clickable { onItemClick() },
                colors = CardDefaults.cardColors(containerColor = if (index == 0) blueBackground else pinkBackGround),
                shape = RoundedCornerShape(20.dp)
            ) {
                ConstraintLayout {
                    val (favoriteIcon, label, body, normalPrice, discountPrice) = createRefs()

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(30.dp)
                            .background(white, CircleShape)
                            .constrainAs(favoriteIcon) {
                                top.linkTo(parent.top, margin = 16.dp)
                                start.linkTo(parent.start, margin = 16.dp)
                            }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.favorite_icon),
                            contentDescription = null,
                            tint = primaryColor,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Text(
                        text = title,
                        style = labelSmall,
                        modifier = Modifier.constrainAs(label) {
                            start.linkTo(parent.start, margin = 16.dp)
                            top.linkTo(favoriteIcon.bottom, margin = 110.dp)
                        }
                    )
                    Text(
                        text = bodyText,
                        style = bodySmall,
                        color = black60,
                        textAlign = TextAlign.Start,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .constrainAs(body) {
                                top.linkTo(label.bottom, margin = 8.dp)
                                start.linkTo(parent.start, margin = 16.dp)
                            }
                            .padding(end = 50.dp)
                    )
                    Text(
                        text = "$16",
                        style = labelLarge,
                        color = black,
                        modifier = Modifier.constrainAs(discountPrice) {
                            top.linkTo(body.bottom, margin = 6.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                    )
                    Text(
                        text = "$20",
                        textDecoration = TextDecoration.LineThrough,
                        style = bodySmall,
                        color = black60,
                        modifier = Modifier.constrainAs(normalPrice) {
                            bottom.linkTo(discountPrice.bottom)
                            end.linkTo(discountPrice.start, margin = 5.dp)
                        }
                    )

                }
            }
            Image(
                painter = painterResource(id = if (index == 0) donutImageId else R.drawable.black_donut),
                contentDescription = null,
                modifier = Modifier
                    .size(135.dp)
                    .constrainAs(donut) {
                        end.linkTo(parent.end, margin = (-50).dp)
                        top.linkTo(parent.top, margin = 35.dp)
                    }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    OffersCard(index = 1){}
}