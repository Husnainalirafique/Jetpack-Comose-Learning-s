package com.husnain.jetpackcompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.husnain.jetpackcompose.nav_graph.MainRoute
import com.husnain.jetpackcompose.nav_graph.mainGraph
import com.husnain.jetpackcompose.ui.theme.JetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Surface(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.MainRoute.name
                    ) {
                        mainGraph(navController)
                    }
                }
            }
        }
    }
}


@Composable
fun FullScreenScrollableColumn(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = "Learnings",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            navController.navigate(MainRoute.VmCountScreen.name)
        }) {
            Text(text = "Viewmodel", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            navController.navigate(MainRoute.LazyColumn.name)
        }) {
            Text(text = "Lazy Column", color = Color.White)
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_6")
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    JetpackComposeTheme {
        FullScreenScrollableColumn(navController)
    }
}

enum class Routes {
    MainRoute
}