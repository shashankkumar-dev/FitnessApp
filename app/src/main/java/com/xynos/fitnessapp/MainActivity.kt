package com.xynos.fitnessapp

import android.Manifest.permission.ACTIVITY_RECOGNITION
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.xynos.fitnessapp.ui.screen.StepScreen
import com.xynos.fitnessapp.ui.theme.FitnessAppTheme
import com.xynos.fitnessapp.ui.viewmodel.StepViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: StepViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StepScreen(viewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        requestPermission()
    }

    private fun requestPermission() {
        val permission = ContextCompat.checkSelfPermission(this, ACTIVITY_RECOGNITION)
        if (permission == PackageManager.PERMISSION_GRANTED) {
            viewModel.startTrackingSteps(this)
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(ACTIVITY_RECOGNITION), 100)
        }
    }
}



