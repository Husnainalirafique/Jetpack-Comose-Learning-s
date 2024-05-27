package com.husnain.jetpackcompose.ui.screens.viewmodelCounter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.husnain.jetpackcompose.ui.theme.JetpackComposeTheme

@Preview(showBackground = true, device = "id:pixel_6", showSystemUi = true)
@Composable
fun CounterScreen(modifier: Modifier = Modifier) {
    JetpackComposeTheme {
        Column(
            modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 40.dp, start = 20.dp, end = 20.dp)
        ) {
            CounterRow()
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun CounterRow(
    modifier: Modifier = Modifier,
) {
    val vm: VmMain = hiltViewModel()
    val count = vm.count.observeAsState(0).value
    Row(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(
            modifier = Modifier.size(width = 120.dp, height = 45.dp),
            onClick = { vm.decrement() }
        ) {
            Text(
                text = "-",
                fontSize = 25.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = count.toString(),
            fontSize = 25.sp,
        )
        Spacer(modifier = Modifier.width(30.dp))

        Button(
            modifier = Modifier.size(width = 120.dp, height = 45.dp),
            onClick = { vm.increment() }
        ) {
            Text(
                text = "+",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}
