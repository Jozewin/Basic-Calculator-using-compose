package com.project.simplecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.simplecalculator.ui.theme.MediumGray
import com.project.simplecalculator.ui.theme.shade_of_orange

@Composable
fun CalculatorApp(
    viewModel: CalculatorViewModel
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            val lineheight = MaterialTheme.typography.displayMedium.fontSize*4/3
            Text(

                text = viewModel.calculatorState.value.answer,
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
                        viewModel.calculatorEvents(CalculatorEvents.AllClear)
                    },
                )
                CalculatorButton(
                    symbols = "Del",
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.DeleteButton)
                    }
                )

                CalculatorButton(
                    symbols = "/",

                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("/"))
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
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("7"))
                    }
                )
                CalculatorButton(
                    symbols = "8",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("8"))
                    }
                )
                CalculatorButton(
                    symbols = "9",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("9"))
                    }
                )
                CalculatorButton(
                    symbols = "x",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("*"))

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
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("4"))
                    }
                )
                CalculatorButton(
                    symbols = "5",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("5"))
                    }
                )
                CalculatorButton(
                    symbols = "6",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("6"))
                    }
                )
                CalculatorButton(
                    symbols = "-",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("-"))
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
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("1"))
                    }
                )
                CalculatorButton(
                    symbols = "2",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("2"))
                    }
                )
                CalculatorButton(
                    symbols = "3",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("3"))
                    }
                )
                CalculatorButton(
                    symbols = "+",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("+"))
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
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("0"))
                    }
                )
                CalculatorButton(
                    symbols = ".",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("."))
                    }
                )
                CalculatorButton(
                    symbols = "=",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.EqualButton)
                    }
                )
            }
        }
    }
}