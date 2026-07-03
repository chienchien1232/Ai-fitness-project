package com.aifitness.app.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aifitness.app.navigation.AppDestination

private val AccentColor = Color(0xFF4CAF50)
private val InactiveColor = Color(0xFF9E9E9E)

@Composable
fun GlassBottomNavigation(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(28.dp),
                clip = false,
                ambientColor = Color.Black.copy(alpha = 0.1f),
                spotColor = Color.Black.copy(alpha = 0.2f)
            ),
        shape = RoundedCornerShape(28.dp),
        color = Color.White.copy(alpha = 0.85f),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.5f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppDestination.bottomNavItems.forEach { screen ->
                // Kiểm tra an toàn để tránh NullPointerException khi route của hệ thống bị null
                val isSelected = currentDestination?.hierarchy?.any {
                    it.route != null && it.route == screen.route
                } == true

                GlassNavItem(
                    icon = screen.icon,
                    label = screen.label,
                    isSelected = isSelected,
                    onClick = {
                        val targetRoute = screen.route
                        if (!isSelected && targetRoute.isNotEmpty()) {
                            navController.navigate(targetRoute) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun GlassNavItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor by animateColorAsState(
        targetValue = if (isSelected) AccentColor else InactiveColor,
        animationSpec = spring(dampingRatio = 0.7f),
        label = "contentColor"
    )
    val pillWidth by animateDpAsState(
        targetValue = if (isSelected) 64.dp else 0.dp,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 300f),
        label = "pillWidth"
    )

    Column(
        modifier = modifier
            .fillMaxHeight()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(pillWidth)
                    .height(32.dp)
                    .background(
                        color = AccentColor.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(16.dp)
                    )
            )
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = contentColor,
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            color = contentColor,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
    }
}