package com.singlepointsol.jetpackcomposenextpagedb

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.database.FirebaseDatabase

@Composable
fun UserInput(navController: NavController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var favouriteFood by remember { mutableStateOf(TextFieldValue("")) }
    var favouriteColor by remember { mutableStateOf(TextFieldValue("")) }

    val context = LocalContext.current // Ensuring context is available

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Enter The Details of User")

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = favouriteFood,
            onValueChange = { favouriteFood = it },
            label = { Text(text = "Favourite Food") },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = favouriteColor,
            onValueChange = { favouriteColor = it },
            label = { Text(text = "Favourite Color") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (name.text.isNotEmpty() && favouriteFood.text.isNotEmpty() && favouriteColor.text.isNotEmpty()) {
                    saveDataToFirebase(name.text, favouriteFood.text, favouriteColor.text, context) {
                        // Passing data through navigation arguments
                        navController.navigate("Details/${name.text}/${favouriteFood.text}/${favouriteColor.text}")
                    }
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

fun saveDataToFirebase(name: String, favouriteFood: String, favouriteColor: String, context: Context, onSuccess: () -> Unit) {
    val database = FirebaseDatabase.getInstance()
    val reference = database.reference.child("Employee")

    val userId = reference.push().key
    val user = User(name, favouriteFood, favouriteColor)

    if (userId != null) {
        reference.child(userId).setValue(user).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Data added successfully", Toast.LENGTH_SHORT).show()
                onSuccess()
            } else {
                Toast.makeText(context, "Failed to add data: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
