package com.mindmatrix.jalsanchay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mindmatrix.jalsanchay.ui.DashboardScreen
import com.mindmatrix.jalsanchay.ui.EntryScreen
import com.mindmatrix.jalsanchay.ui.ReportScreen
import com.mindmatrix.jalsanchay.ui.SetupScreen
import com.mindmatrix.jalsanchay.ui.TipsScreen
import com.mindmatrix.jalsanchay.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val viewModel: MainViewModel = hiltViewModel()

                    NavHost(
                        navController = navController,
                        startDestination = "dashboard"
                    ) {
                        composable("dashboard") {
                            DashboardScreen(navController, viewModel)
                        }
                        composable("setup") {
                            SetupScreen(navController, viewModel)
                        }
                        composable("entry") {
                            EntryScreen(navController, viewModel)
                        }
                        composable("report") {
                            ReportScreen(navController, viewModel)
                        }
                        composable("tips") {
                            TipsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}