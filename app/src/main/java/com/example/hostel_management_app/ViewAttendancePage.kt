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

data class AttendanceRecord(val studentId: String, val date: String)

@Composable
fun ViewAttendancePage(navController: NavController) {
    var studentId by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var attendanceRecords by remember { mutableStateOf(listOf<AttendanceRecord>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = studentId, onValueChange = { studentId = it },
            modifier = Modifier.fillMaxWidth(), singleLine = true,
            label = { Text(text = "Enter Student ID")}
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text(text = "Enter Date")},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            attendanceRecords = attendanceRecords + AttendanceRecord(studentId, date)
        }) {
            Text("Log Attendance")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(attendanceRecords.size) { index ->
                Text(text = "Student ID: ${attendanceRecords[index].studentId}, Date: ${attendanceRecords[index].date}")
            }
        }
    }
}
@Preview
@Composable
fun ViewAttendancePagePreview() {
    HostelManagementAppTheme {
        ViewAttendancePage(navController = rememberNavController())
    }
}