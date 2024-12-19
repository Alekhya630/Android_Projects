package com.singlepointsol.basiccomposeuidemo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.singlepointsol.basiccomposeuidemo.ui.theme.LoginPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           LoginPage()
        }
    }
}
/*
                Text(
                    text = "Welcome to Jet Pack Compose",
                    fontSize = 30.sp,
                    color = Color.Blue
                )
                Text(
                    text = "Lets write Text Lines",
                    fontSize = 24.sp
                )
                Row {
                    ElevatedButton(onClick = {

                    }) {
                        Text(text = "Click Me")
                    }
                    Button(onClick = {

                    }) {
                        Text(text = "Click Me")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.android),
                    contentDescription = stringResource(id = R.string.sample_image),
                    alignment = Alignment.Center
                )
                TextField(value = "Name", onValueChange = {})
            }
            */