package com.example.hostel_management_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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

data class PermissionRequest(val purpose: String, val duration: String)

@Composable
fun GuardianPage(navController: NavController) {
    var purpose by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var requests by remember { mutableStateOf(listOf<PermissionRequest>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = purpose, onValueChange = { purpose = it }, modifier = Modifier.fillMaxWidth(),
            singleLine = true, label= {Text(text = "Enter Purpose")})
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = duration, onValueChange = { duration = it }, modifier = Modifier.fillMaxWidth(),
            singleLine = true, label = { Text(text = "Enter Duration")})
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (purpose.isNotEmpty() && duration.isNotEmpty()) {
                requests = requests + PermissionRequest(purpose, duration)
            }
        }) {
            Text("Send Permission Request")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(requests.size) { index ->
                Text(text = "Purpose: ${requests[index].purpose}, Duration: ${requests[index].duration}")
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GuardianPage() {
    HostelManagementAppTheme {
        GuardianPage(navController = rememberNavController())
    }
}