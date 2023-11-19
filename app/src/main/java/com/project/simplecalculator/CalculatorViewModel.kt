package com.project.simplecalculator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorViewModel : ViewModel() {

    private val _calculatorState = mutableStateOf(CalculatorState())
    val calculatorState: State<CalculatorState> = _calculatorState


    fun calculatorEvents(
        events: CalculatorEvents
    ) {
        when (events) {
            CalculatorEvents.AllClear -> {
                _calculatorState.value = calculatorState.value.copy(
                    answer = ""
                )
            }

            CalculatorEvents.DeleteButton -> {
                if (_calculatorState.value.answer.isNotEmpty()) {
                    _calculatorState.value = calculatorState.value.copy(
                        answer = _calculatorState.value.answer.dropLast(1)
                    )
                }

            }

            CalculatorEvents.EqualButton -> {
                viewModelScope.launch{
                    val calculatedAnswer = isEqualClick(_calculatorState.value.answer)
                    _calculatorState.value = calculatorState.value.copy(
                        answer = calculatedAnswer
                    )
                }
            }

            is CalculatorEvents.InputNumber -> {
                _calculatorState.value = calculatorState.value.copy(
                    answer = _calculatorState.value.answer + events.number
                )
            }

            is CalculatorEvents.InputSymbol -> {
                if (_calculatorState.value.answer.isEmpty()) return
                else if (_calculatorState.value.answer.lastOrNull() !in arrayOf(
                        '+',
                        '-',
                        '*',
                        '.',
                        '/'
                    )
                ) {
                    _calculatorState.value = calculatorState.value.copy(
                        answer = calculatorState.value.answer + events.symbol
                    )
                }
            }
        }

    }

    private fun isEqualClick(text: String): String {
        if (text.isEmpty() || text.lastOrNull()!in arrayOf(
                '+',
                '-',
                '*',
                '.',
                '/'
            ) )     return text

        val eval = ExpressionBuilder(text).build()
        val res = eval.evaluate()
        return res.toInt().toString()
    }
}