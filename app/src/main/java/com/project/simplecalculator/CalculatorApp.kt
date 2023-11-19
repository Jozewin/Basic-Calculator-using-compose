package com.project.simplecalculator

import android.hardware.ConsumerIrManager
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

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
    viewModel: CalculatorViewModel,
    irManager: ConsumerIrManager
) {

//    var authUnlock by remember {
//        mutableStateOf("")
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            val lineheight = MaterialTheme.typography.displayMedium.fontSize * 4 / 3
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

//                        if (authUnlock == "10"){
//                            val pattern = intArrayOf(
//                                200,
//                                400,
//                                600,
//                                800,
//                                1000,
//                                1200
//                            ) // Example pattern, replace with your IR signal pattern
//                            irManager.transmit(40000, pattern)
//                        }

                    },
                )
                CalculatorButton(
                    symbols = "Del",
                    modifier = Modifier
                        .background(Color.Gray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.DeleteButton)
                        val pattern = intArrayOf(
                            9000,
                            4500,
                            560,
                            560,
                            560,
                            1690,
                            560,
                            1690
                        ) // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )

                CalculatorButton(
                    symbols = "/",

                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("/"))
                        val pattern = intArrayOf(
                            9000,
                            4500,
                            560,
                            560,
                            560,
                            1690,
                            560,
                            1690,
                            250,
                            5000
                        )  // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
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
                        val pattern = intArrayOf(
                            9000,
                            4500,
                            560,
                            1690,
                            560,
                            1690,
                            560,
                            560
                        ) //ttern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "8",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("8"))
                        val pattern = intArrayOf(
                            9000,
                            4500,
                            560,
                            560,
                            560,
                            1690,
                            560,
                            560,
                            600,
                            600,
                            2000,
                            300
                        ) // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "9",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("9"))
                        val pattern = intArrayOf(
                            9000,
                            4500,
                            560,
                            1690,
                            560,
                            560,
                            560,
                            1690
                        )  // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "x",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("*"))
                        val pattern = intArrayOf(
                            560,
                            560,
                            560,
                            1690,
                            560,
                            1690,
                            9000,
                            4500
                        ) // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
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
                        val pattern = intArrayOf(
                            560,
                            560,
                            560,
                            560,
                            560,
                            1690,
                            560,
                            1690
                        ) // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "5",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("5"))
                        val pattern = intArrayOf(
                            560,
                            1690,
                            560,
                            1690,
                            9000,
                            4500,
                            560,
                            560
                        )  // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "6",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("6"))
                        val pattern = intArrayOf(
                            560,
                            560,
                            560,
                            560,
                            1690,
                            560,
                            1690,
                            9000
                        ) // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "-",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("-"))
                        val pattern = intArrayOf(
                            560,
                            1690,
                            9000,
                            4500,
                            560,
                            560,
                            560,
                            1690
                        )  // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
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
                        val pattern = intArrayOf(
                            560,
                            1690,
                            560,
                            560,
                            560,
                            560,
                            9000,
                            4500
                        )// Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "2",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("2"))
                        val pattern = intArrayOf(
                            4500,
                            560,
                            560,
                            560,
                            1690,
                            560,
                            1690,
                            9000
                        )// Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "3",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputNumber("3"))
                        val pattern = intArrayOf(
                            560,
                            1690,
                            560,
                            560,
                            560,
                            1690,
                            9000,
                            4500
                        )  // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "+",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("+"))
                        val pattern = intArrayOf(
                            560,
                            1690,
                            9000,
                            4500,
                            560,
                            1690,
                            560,
                            560
                        )// Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
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
                        val pattern = intArrayOf(
                            560,
                            560,
                            560,
                            1690,
                            9000,
                            4500,
                            560,
                            1690
                        ) // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = ".",
                    modifier = Modifier
                        .background(MediumGray)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.InputSymbol("."))
                        val pattern = intArrayOf(
                            9000,
                            4500,
                            560,
                            560,
                            560,
                            560,
                            560,
                            1690
                        ) // Example pattern, replace with your IR signal pattern
                        irManager.transmit(40000, pattern)
                    }
                )
                CalculatorButton(
                    symbols = "=",
                    modifier = Modifier
                        .background(shade_of_orange)
                        .weight(1f),
                    onClick = {
                        viewModel.calculatorEvents(CalculatorEvents.EqualButton)


//                        if (authUnlock != "10")
//                            authUnlock = viewModel.calculatorState.value.answer
//                        if (authUnlock == "10") {
//                            val pattern = intArrayOf(
//                                560,
//                                1690,
//                                560,
//                                1690,
//                                560,
//                                560,
//                                9000,
//                                4500
//                            ) // Example pattern, replace with your IR signal pattern
//                            irManager.transmit(40000, pattern)
//                        }
                    }
                )
            }
        }
    }
}