package com.singlepointsol.jetpackcomposerealtimedb

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.database.FirebaseDatabase


@Composable
fun UserInput() {
    //  text fields
    var name by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var favouriteFood by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var favouriteColor by remember {
        mutableStateOf(TextFieldValue(""))
    }

    val context = LocalContext.current

    // To keep in center
    Column(
        modifier = Modifier.fillMaxSize().padding(18.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Enter The Details of User", style = TextStyle(fontSize = 20.sp, color = Color.Green)
        )


        Spacer(modifier = Modifier.height(8.dp))

        //  Name
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        //  Email
        OutlinedTextField(
            value = favouriteFood,
            onValueChange = { favouriteFood = it },
            label = { Text(text = "Favourite Food") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Phone
        OutlinedTextField(
            value = favouriteColor,
            onValueChange = { favouriteColor = it },
            label = { Text(text = "Favourite Color") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit btn
        Button(
            onClick = {
                if (name.text.isNotEmpty() && favouriteFood.text.isNotEmpty() && favouriteColor.text.isNotEmpty()) {
                    saveDataToFirebase(name.text, favouriteFood.text, favouriteColor.text, context)
                } else {
                    Toast.makeText(context, "Please fill all details", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}

//Connecting to firebase database
fun saveDataToFirebase(name: String, favouriteFood: String, favouriteColor: String, context: android.content.Context) {
    val database = FirebaseDatabase.getInstance()
    val reference = database.reference.child("Employee")

    // Create a unique key for each user
    val userId = reference.push().key

    val employee = Employee(name, favouriteFood, favouriteColor)

    if (userId != null) {
        reference.child(userId).setValue(employee).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Data added successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Not added: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
