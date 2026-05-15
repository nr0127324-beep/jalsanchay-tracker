package com.mindmatrix.jalsanchay.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipsScreen(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Water Harvesting Tips") }) }) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text("💡 Pro Tips for Better Harvesting", style = MaterialTheme.typography.headlineSmall)
            }
            items(listOf(
                "Clean your roof regularly to avoid contamination",
                "First 10 minutes of rain should be diverted (first flush)",
                "Use leaf filters before water enters the tank",
                "Keep your storage tank covered and clean",
                "Check for leaks in gutters and pipes",
                "Use harvested water for gardening and toilet flushing",
                "Install overflow pipe to prevent wastage"
            )) { tip ->
                Card {
                    Text(
                        text = tip,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}