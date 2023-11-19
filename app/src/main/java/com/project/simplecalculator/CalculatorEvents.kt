package com.project.simplecalculator

sealed interface CalculatorEvents{
    data class InputNumber(val number : String) : CalculatorEvents
    data class InputSymbol(val symbol : String) : CalculatorEvents

    object EqualButton : CalculatorEvents
    object AllClear : CalculatorEvents
    object DeleteButton : CalculatorEvents

}