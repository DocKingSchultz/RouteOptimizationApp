package com.yourname.routeoptimization

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yourname.routeoptimization.ui.theme.RouteOptimizationAppTheme

class MainActivity : ComponentActivity() {

    // Load the native library
    companion object {
        init {
            System.loadLibrary("RouteOptimizationAPI")  // Name without `lib` and `.so`
        }
    }

    // Declare native function
    external fun calculateDistance(address1: String, address2: String): Double

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Example addresses
        val address1 = "New York"
        val address2 = "Los Angeles"


        val button = findViewById<Button>(R.id.calculateButton)
        val textView = findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            val result = calculateDistance("New York", "Los Angeles")
            textView.text = "Distance: $result km"
        }

    }
}

