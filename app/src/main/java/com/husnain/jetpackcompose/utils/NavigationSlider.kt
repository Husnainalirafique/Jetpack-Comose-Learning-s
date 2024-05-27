package com.husnain.jetpackcompose.utils

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

object NavigationSlider {
    fun enterSlideInToStart(durationMillis: Int = 600) = slideInHorizontally(
        initialOffsetX = { it }, animationSpec = tween(durationMillis)
    )

    fun exitSlideInToStart(durationMillis: Int = 600) = slideOutHorizontally(
        targetOffsetX = { -it }, animationSpec = tween(durationMillis)
    )

    fun popExitSlideToEnd(durationMillis: Int = 600) = slideOutHorizontally(
        targetOffsetX = { it }, animationSpec = tween(durationMillis)
    )

    fun popEnterSlideToEnd(durationMillis: Int = 600) = slideInHorizontally(
        initialOffsetX = { -it }, animationSpec = tween(durationMillis)
    )
}