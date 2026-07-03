package com.aifitness.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.aifitness.app.navigation.AppNavGraph
import com.aifitness.app.ui.components.GlassBottomNavigation

@Composable
fun AiFitnessApp() {
    val navController = rememberNavController()

    // Sử dụng Box để xếp chồng: Nội dung ở dưới, Bottom Bar nổi ở trên
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 1. Luồng điều hướng chính (Nội dung các màn hình)
            AppNavGraph(navController = navController)

            // 2. Thanh điều hướng nổi (Floating) đặt ở dưới cùng
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                GlassBottomNavigation(navController = navController)
            }
        }
    }
}
