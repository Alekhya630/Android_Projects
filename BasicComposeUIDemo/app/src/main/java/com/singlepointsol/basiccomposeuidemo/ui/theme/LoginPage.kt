package com.singlepointsol.basiccomposeuidemo.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.singlepointsol.basiccomposeuidemo.R


@Composable
fun LoginPage(){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Image(painter = painterResource(R.drawable.rose),
            contentDescription = stringResource(id=R.string.sample_image),
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(top=60.dp)
        )
        OutlinedTextField(value = email, onValueChange = {
            email=it
        },
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            label = {
                Text(text="Email")
            })
        OutlinedTextField(value = password, onValueChange = {
           password=it
        },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text="Password")
            })
        Row(horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth())
        {
            Button(onClick = {},Modifier.padding(horizontal = 4.dp)) {
                Text(text = "Sign Up")
            }
            Button(onClick = {
                Log.e("Login Details","Email:$email,Password:$password")
            },Modifier.padding(horizontal = 4.dp)) {
                Text(text = "Login")
            }
        }
    }

}