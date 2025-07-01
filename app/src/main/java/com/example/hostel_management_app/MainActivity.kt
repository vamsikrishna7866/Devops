package com.example.hostel_management_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Nullable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hostel_management_app.ui.theme.HostelManagementAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HostelManagementAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HostelManagementApp()
                }
            }
        }
    }
}

@Composable
fun HostelManagementApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController = navController)}
        composable("sign-in") { RegisterScreen(navController = navController)}
        composable("adminPage") { AdminPage(navController) }
        composable("manageRooms") { ManageRoomsPage(navController) }
        composable("manageStudents") { ManageStudentsPage(navController) }
        composable("viewAttendance") { ViewAttendancePage(navController) }
        composable("studentPage") { StudentPage(navController) }
        composable("guardianPage") { GuardianPage(navController) }
        composable("wardenPage") { WardenPage(navController) }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HostelManagementAppPreview() {
    HostelManagementAppTheme {
        HostelManagementApp()
    }
}
