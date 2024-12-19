package com.singlepointsol.dogslazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.singlepointsol.dogslazycolumn.ui.theme.DogsLazyColumnTheme // Correct package path

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogGridDemo() // Correct function name
        }
    }
}
