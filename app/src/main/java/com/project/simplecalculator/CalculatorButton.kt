package com.project.simplecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbols: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onClick()}
            .clip(CircleShape)
            .then(modifier),contentAlignment = Alignment.Center,

    ){
        Text(
            text = symbols,
            color = Color.White,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)

        )
    }
}

@Preview
@Composable
fun ButtonPrev() {
    Row(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
        CalculatorButton(symbols = "1"
            , onClick = { /*TODO*/ }
            , modifier = Modifier
                .weight(2f)
                .background(Color.LightGray))

        CalculatorButton( symbols = "2"
            ,onClick = { /*TODO*/ }
            , modifier = Modifier
                .weight(1f)
                .background(Color.DarkGray))
    }

}