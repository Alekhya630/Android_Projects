package com.singlepointsol.basiccomposeapp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(){

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFE7C8C8)), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(painter = painterResource(R.drawable.login), contentDescription = "Login image",
            //Toget image in middle
            modifier = Modifier.size(200.dp))
        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Login to your account")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value=email, onValueChange =
        {
            email=it
        }, label=
        {
            Text(text = "Email address")
        })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value=password, onValueChange =
        {
            password=it
        }, label=
        {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())
        //visualTransformation = PasswordVisualTransformation()->For getting password in hide

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick =
        {
            Log.i("Credentials","Email:$email Password:$password")
        })
        {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Forgot Password?", modifier = Modifier.clickable
        {

        })
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Or sign in with")

        Row (
            modifier = Modifier.fillMaxWidth().padding(40.dp),
            //to get space between image
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Image(painter = painterResource(id = R.drawable.fb), contentDescription = "Youtube",
                modifier = Modifier.size(60.dp).clickable {

                })
            Image(painter = painterResource(id = R.drawable.twitter), contentDescription = "Twitter",
                modifier = Modifier.size(60.dp).clickable {

                })
            Image(painter = painterResource(id = R.drawable.lin), contentDescription = "Facebook",
                modifier = Modifier.size(60.dp).clickable {

                })
        }

    }

}