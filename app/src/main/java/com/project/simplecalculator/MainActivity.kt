package com.project.simplecalculator

import android.content.Context
import android.hardware.ConsumerIrManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.simplecalculator.ui.theme.SimpleCalculatorTheme

class MainActivity : ComponentActivity() {
    private lateinit var irManager : ConsumerIrManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    irManager = getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager
                    if (irManager == null || !irManager.hasIrEmitter()) {
                        Toast.makeText(this, "IR Blaster not available on this device", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    val viewModel = viewModel<CalculatorViewModel>()
                    CalculatorApp(viewModel, irManager)                }
            }
        }
    }
}
