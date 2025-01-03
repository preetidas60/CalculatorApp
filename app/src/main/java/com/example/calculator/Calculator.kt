package com.example.calculator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme


var buttonList = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "-",
    "1", "2", "3", "+",
    "AC","0", ".", "="
)


@Composable
fun Calculator(modifier : Modifier = Modifier){
    Box(modifier = modifier){
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End

        ){
            Text(text = "123+123",
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(text = "246",
                style = TextStyle(
                    fontSize = 60.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 2,
            )

            Spacer(modifier = Modifier.height(40.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
            ) {
                items(buttonList) {
                    CalculatorButton(button = it)
                }
            }
        }
    }
}



@Composable
fun CalculatorButton(button : String){
    Box(
        modifier = Modifier.padding(10.dp)
    ){
        FloatingActionButton(onClick = {   },
            modifier = Modifier.size(80.dp),
            containerColor = getColor(button),
            contentColor = Color.White
        )
        {
            Text(text = button,
                style = TextStyle(
                    fontSize = 25.sp,
//                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}


fun getColor(button: String): Color {
    return when (button) {
        "AC", "C" -> Color(0xFFF38F8F) // Red for clear buttons
        "(", ")" -> Color(0xFFB3B1B0) // Orange for parentheses
        "/", "*", "-", "+", "=" -> Color(0xFFF1CD96) // Blue for operators
        else -> Color(0xFFC6B0EE) // Black for default buttons
    }
}


@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorTheme {
        Calculator()
    }
}