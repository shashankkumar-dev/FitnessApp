package com.xynos.fitnessapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.xynos.fitnessapp.ui.theme.FitnessAppTheme
import com.xynos.fitnessapp.ui.viewmodel.StepViewModel


@Composable
fun StepCounterUI(steps: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Steps: $steps",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun StepScreen(viewModel: StepViewModel = hiltViewModel()) {
    val steps by viewModel.step.collectAsState()
    StepCounterUI(steps)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FitnessAppTheme {
        StepScreen()
    }
}