package com.jamirodev.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jamirodev.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                DrinkingLemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun DrinkingLemonadeApp(){
    LemonadeWithFunctions()
}

@Composable
fun LemonadeWithFunctions(modifier: Modifier = Modifier){
    val lemonTreeTxtList = listOf(
        stringResource(R.string.Lemon_tree),
        stringResource(R.string.keep_tapping),
        stringResource(R.string.drink_lemon),
        stringResource(R.string.restart_lemon)
    )

    val lemonTreeImgList = listOf(
        painterResource(R.drawable.lemon_tree),
        painterResource(R.drawable.lemon_squeeze),
        painterResource(R.drawable.lemon_drink),
        painterResource(R.drawable.lemon_restart)
    )
    var currentIndex by remember { mutableStateOf(0) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFEECC))
            .clickable {
                currentIndex = (currentIndex + 1) % lemonTreeTxtList.size
            }

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = lemonTreeTxtList[currentIndex],
                style = TextStyle(fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.height(18.dp))
            Image(
                painter = lemonTreeImgList[currentIndex],
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}