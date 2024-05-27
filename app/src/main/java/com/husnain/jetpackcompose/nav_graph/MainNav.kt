package com.husnain.jetpackcompose.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.husnain.jetpackcompose.ui.activities.FullScreenScrollableColumn
import com.husnain.jetpackcompose.ui.activities.Routes
import com.husnain.jetpackcompose.ui.screens.lazyColumn.LazyColumnScreen
import com.husnain.jetpackcompose.ui.screens.viewmodelCounter.CounterScreen
import com.husnain.jetpackcompose.utils.NavigationSlider

fun NavGraphBuilder.mainGraph(navController: NavController) {
    navigation(
        startDestination = MainRoute.HomeScreen.name, route = Routes.MainRoute.name
    ) {

        composable(
            route = MainRoute.HomeScreen.name,
            exitTransition = { NavigationSlider.exitSlideInToStart(400) },
            popEnterTransition = { NavigationSlider.popEnterSlideToEnd(400) }
        ) { FullScreenScrollableColumn(navController) }

        composable(
            route = MainRoute.VmCountScreen.name,
            enterTransition = { NavigationSlider.enterSlideInToStart(400) },
            popExitTransition = { NavigationSlider.popExitSlideToEnd(400) },
        ) { CounterScreen() }

        composable(
            route = MainRoute.LazyColumn.name,
            enterTransition = { NavigationSlider.enterSlideInToStart(400) },
            popExitTransition = { NavigationSlider.popExitSlideToEnd(400) },
        ) { LazyColumnScreen() }
    }
}

enum class MainRoute {
    HomeScreen,
    VmCountScreen,
    LazyColumn
}
