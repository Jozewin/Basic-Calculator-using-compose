package com.project.simplecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.simplecalculator.ui.theme.MediumGray
import com.project.simplecalculator.ui.theme.shade_of_orange
import net.objecthunter.exp4j.ExpressionBuilder

@Composable
fun CalculatorApp() {
    /*
    State to save the shit
     */
    var result by remember {
        mutableStateOf("")
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            var lineheight = MaterialTheme.typography.displayMedium.fontSize*4/3
            Text(

                text = result,
                fontSize = 64.sp,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth(),
                 maxLines = 5,
                color = Color.White,
                lineHeight = lineheight
            )

            /*
            Buttons Category
            */

            /*
            All Clear, Delete, Divide
            */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbols = "AC",
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(2f),
                    onClick = {
                        result = ""
                    },
                )
                CalculatorButton(
                    symbols = "Del",
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f),
                    onClick = {
                        if (result.isNotEmpty()) {
                            result = result.dropLast(1)
                        }
                    }
                )

                CalculatorButton(
                    symbols = "/",

                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        if (result.isEmpty()) return@CalculatorButton
                        else if (result.lastOrNull() !in arrayOf('+', '-', '*', '.', '/'))
                            result += "/"
                    }
                )
            }

            /*
               seven, eight, nine, multiplication
            */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbols = "7",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "7"
                    }
                )
                CalculatorButton(
                    symbols = "8",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "8"
                    }
                )
                CalculatorButton(
                    symbols = "9",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "9"
                    }
                )
                CalculatorButton(
                    symbols = "x",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        if (result.isEmpty()) return@CalculatorButton
                        else if (result.lastOrNull() !in arrayOf('+', '-', '*', '.', '/'))
                            result += "*"
                    }
                )
            }

            /*
            Four, Five, Six, Subtract
             */

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbols = "4",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "4"
                    }
                )
                CalculatorButton(
                    symbols = "5",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "5"
                    }
                )
                CalculatorButton(
                    symbols = "6",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "6"
                    }
                )
                CalculatorButton(
                    symbols = "-",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        if (result.isEmpty()) return@CalculatorButton
                        else if (result.lastOrNull() !in arrayOf('+', '-', '*', '.', '/'))
                            result += "-"
                    }
                )
            }

            /*
            One, Second, Three, Plus
             */

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbols = "1",
                    modifier = Modifier
                        .background(color = MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "1"
                    }
                )
                CalculatorButton(
                    symbols = "2",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "2"
                    }
                )
                CalculatorButton(
                    symbols = "3",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        result += "3"
                    }
                )
                CalculatorButton(
                    symbols = "+",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        if (result.isEmpty()) return@CalculatorButton
                        else if (result.lastOrNull() !in arrayOf('+', '-', '*', '.', '/'))
                            result += "+"
                    }
                )
            }

            /*
            Zero, Dot, Equal
             */

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                CalculatorButton(
                    symbols = "0",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(2f),
                    onClick = {
                        result += "0"
                    }
                )
                CalculatorButton(
                    symbols = ".",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        if (result.isEmpty()) {
                            return@CalculatorButton
                        }

                        if (result.lastOrNull() !in arrayOf('+', '-', '*', '.'))
                            result += "."
                    }
                )
                CalculatorButton(
                    symbols = "=",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        if (result.isEmpty()) {
                            // result.append("")
                            return@CalculatorButton
                        }
                        if (result.lastOrNull() !in arrayOf('+', '-', '*', '.', '/')) {
                            result = Calculation(result)
                        }
                    }
                )
            }
        }
    }
}

@Preview(backgroundColor = 0)
@Composable
fun prevCalculator() {

    CalculatorApp()
}

private fun Calculation(text: String): String {
    val eval = ExpressionBuilder(text).build()
    val res = eval.evaluate()
    return res.toInt().toString()
}