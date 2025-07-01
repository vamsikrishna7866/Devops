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

data class Room(val name: String, val isBedroom: Boolean, val beds: Int = 0)

@Composable
fun ManageRoomsPage(navController: NavController) {
    var roomName by remember { mutableStateOf("") }
    var isBedroom by remember { mutableStateOf(false) }
    var beds by remember { mutableStateOf(0) }
    var rooms by remember { mutableStateOf(listOf<Room>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = roomName,
            onValueChange = { roomName = it },
            label = { Text(text = "Enter Room Name or Number")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = { isBedroom = true }) { Text("Bedroom") }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { isBedroom = false }) { Text("General Room") }
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (isBedroom) {
            TextField(
                value = beds.toString(),
                onValueChange = { beds = it.toIntOrNull() ?: 0 },
                label = { Text(text = "Enter number of beds")}
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (roomName.isNotEmpty()) {
                rooms = rooms + Room(roomName, isBedroom, beds)
                roomName = ""
                isBedroom = false
                beds = 0
            }
        }) {
            Text("Add Room")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(rooms.size) { index ->
                Text(text = "Room: ${rooms[index].name}, Type: ${if (rooms[index].isBedroom) "Bedroom" else "General"}, Beds: ${rooms[index].beds}")
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ManageRoomsPagePreview() {
    HostelManagementAppTheme {
        ManageRoomsPage(navController = rememberNavController())
    }
}