package com.mindmatrix.jalsanchay.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mindmatrix.jalsanchay.viewmodel.MainViewModel

@Composable
fun SetupScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    var roof by remember {
        mutableStateOf(
            viewModel.roofArea.value.toString()
        )
    }

    var tank by remember {
        mutableStateOf(
            viewModel.tankCapacity.value.toString()
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            "Home Setup",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = roof,

            onValueChange = {
                roof = it
            },

            label = {
                Text("Roof Area (sq.m)")
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = tank,

            onValueChange = {
                tank = it
            },

            label = {
                Text("Tank Capacity (Liters)")
            },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {

                viewModel.roofArea.value =
                    roof.toDoubleOrNull() ?: 100.0

                viewModel.tankCapacity.value =
                    tank.toDoubleOrNull() ?: 1000.0

                navController.popBackStack()
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Save Configuration")
        }
    }
}