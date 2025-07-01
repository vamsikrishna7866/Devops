package com.example.hostel_management_app

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hostel_management_app.ui.theme.HostelManagementAppTheme

@Composable
fun AdminPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("manageRooms") }) {
            Text("Manage Rooms")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("manageStudents") }) {
            Text("Manage Students")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("viewAttendance") }) {
            Text("View Attendance")
        }
        Button(onClick = { navController.navigate("wardenPage") }) {
            Text("Warden")
        }
        Button(onClick = { navController.navigate("guardianPage") }) {
            Text("Guardian")
        }
        Button(onClick = { navController.navigate("studentPage") }) {
            Text("Student")
        }
    }
}
@Preview
@Composable
fun AdminPagePreview() {
    HostelManagementAppTheme {
        AdminPage(navController = rememberNavController())
    }
}

