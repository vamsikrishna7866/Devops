package com.example.hostel_management_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hostel_management_app.ui.theme.HostelManagementAppTheme

@Composable
fun WardenPage(navController: NavController) {
    var requests by remember { mutableStateOf(listOf<PermissionRequest>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(requests.size) { index ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Purpose: ${requests[index].purpose}, Duration: ${requests[index].duration}")
                    Row {
                        Button(onClick = {
                            requests = requests - requests[index]
                        }) {
                            Text("Approve")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = {
                            requests = requests - requests[index]
                        }) {
                            Text("Reject")
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WardenPagePreview() {
    HostelManagementAppTheme {
        WardenPage(navController = rememberNavController())
    }
}