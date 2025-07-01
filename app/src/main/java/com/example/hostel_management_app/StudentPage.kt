package com.example.hostel_management_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hostel_management_app.ui.theme.HostelManagementAppTheme

@Composable
fun StudentPage(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier.fillMaxWidth(), singleLine = true,
            label = { Text(text = "Enter Username")}
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(), singleLine = true,
            label = { Text(text = "Enter Password")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Simulate Login
            if (username == "student" && password == "password") {
                navController.navigate("homePage")
            }
        }) {
            Text("Login")
        }
    }
}
@Preview
@Composable
fun StudentPagePreview() {
    HostelManagementAppTheme {
        StudentPage(navController = rememberNavController())
    }
}
