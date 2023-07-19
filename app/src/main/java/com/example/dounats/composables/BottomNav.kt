package com.example.dounats.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dounats.R
import com.example.dounats.ui.theme.primaryColor
import com.example.dounats.ui.theme.white


@Composable
fun BottomNav() {
    BottomNavigation(
        backgroundColor = white,
        modifier = Modifier.padding(bottom = 4.dp),
        elevation = 0.dp
    ) {
        BottomNavItem(iconId = R.drawable.home)
        BottomNavItem(iconId = R.drawable.heart)
        BottomNavItem(iconId = R.drawable.notification)
        BottomNavItem(iconId = R.drawable.buy)
        BottomNavItem(iconId = R.drawable.profile_icon)

    }
}

@Composable
private fun RowScope.BottomNavItem(iconId: Int) {
    BottomNavigationItem(
        selected = false,
        onClick = {},
        icon = {
            Box(modifier = Modifier.size(52.dp)) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    modifier = Modifier.align(
                        Alignment.Center,
                    ),
                    tint = primaryColor
                )
            }
        }
    )

}