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

data class Student(val id: String, val name: String, var room: Room? = null)

@Composable
fun ManageStudentsPage(navController: NavController) {
    var studentId by remember { mutableStateOf("") }
    var studentName by remember { mutableStateOf("") }
    var students by remember { mutableStateOf(listOf<Student>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = studentId,
            onValueChange = { studentId = it },
            label = { Text(text = "Enter Student Id")},
            modifier = Modifier.fillMaxWidth(), singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text(text = "Enter Student Name")},
            modifier = Modifier.fillMaxWidth(), singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (studentId.isNotEmpty() && studentName.isNotEmpty()) {
                students = students + Student(studentId, studentName)
                studentId = ""
                studentName = ""
            }
        }) {
            Text("Add Student")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(students.size) { index ->
                Text(text = "ID: ${students[index].id}, Name: ${students[index].name}, Room: ${students[index].room?.name ?: "Not Allocated"}")
            }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ManageStudentsPagePreview() {
    HostelManagementAppTheme {
        ManageStudentsPage(navController = rememberNavController())
    }
}
