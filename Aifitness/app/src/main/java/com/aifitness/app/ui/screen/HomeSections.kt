package com.aifitness.app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aifitness.app.ui.components.*
import com.aifitness.domain.model.FitnessMetrics

import java.util.Locale

@Composable
fun HomeMiddleSection(
    onAICoachClick: () -> Unit = {},
    onTodayWorkoutClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                GlassCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onAICoachClick() },
                    padding = PaddingValues(16.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🤖", style = MaterialTheme.typography.titleMedium)
                            Spacer(Modifier.width(8.dp))
                            Text("AI Coach", fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "Xem lời khuyên sức khỏe hôm nay",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray
                        )
                    }
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                GlassCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onTodayWorkoutClick() },
                    padding = PaddingValues(16.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🏋️", style = MaterialTheme.typography.titleMedium)
                            Spacer(Modifier.width(8.dp))
                            Text("Workout Today", fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "Xem bài tập được gợi ý cho bạn",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier.weight(1f)) {
                SummarySmallCard("Water", "1.5 Liters")
            }
            Box(modifier = Modifier.weight(1f)) {
                SummarySmallCard("Weight", "70 kg")
            }
        }
    }
}

@Composable
fun SummarySmallCard(label: String, value: String) {
    GlassCard(
        modifier = Modifier.fillMaxWidth(),
        padding = PaddingValues(16.dp)
    ) {
        Column {
            Text(label, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
            Text(value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TodaySummarySection(metrics: FitnessMetrics) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        SectionTitle("Today's Overview", color = Color.Black)
        Spacer(Modifier.height(12.dp))

        GlassCard(
            modifier = Modifier.fillMaxWidth(),
            padding = PaddingValues(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        MetricCard("Calories", metrics.calories.toString(), "kcal")
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        MetricCard("Heart", metrics.heartRate.toString(), "bpm")
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        MetricCard("Steps", String.format(Locale.getDefault(), "%,d", metrics.steps), "")
                    }
                    Box(modifier = Modifier.weight(1f)) {
                        MetricCard("Moving", metrics.movingMinutes.toString(), "min")
                    }
                }
            }
        }
    }
}

@Composable
fun AITrainerSection(onAICoachClick: () -> Unit = {}) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        GlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onAICoachClick() },
            padding = PaddingValues(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text("🤖", style = MaterialTheme.typography.headlineSmall)
                        SectionTitle("AI Health Coach", color = Color.Black)
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Dựa trên dữ liệu hôm nay, hãy đi bộ thêm 15 phút để hoàn thành mục tiêu nhé!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
                Spacer(Modifier.width(16.dp))
                Text(
                    text = "Chat",
                    color = Color(0xFF4CAF50),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onAICoachClick() }
                )
            }
        }
    }
}

@Composable
fun WorkoutTodaySection(onTodayWorkoutClick: () -> Unit = {}) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        SectionTitle("Today's Workout", color = Color.Black)
        Spacer(Modifier.height(12.dp))
        GlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onTodayWorkoutClick() },
            padding = PaddingValues(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                color = Color(0xFF4CAF50).copy(alpha = 0.1f),
                                shape = RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🏋️", style = MaterialTheme.typography.headlineSmall)
                    }
                    Column {
                        Text(
                            "Full Body Training",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            "Gợi ý riêng cho bạn",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }
                }
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        "30",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4CAF50)
                    )
                    Text(
                        " min",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RecentActivitySection(recentActivities: List<String> = listOf("Running - 3.2 km", "Cycling - 12 km")) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        SectionTitle("Recently", color = Color.Black)
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0.7f), shape = RoundedCornerShape(24.dp))
                .padding(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                if (recentActivities.isEmpty()) {
                    Text("Chưa có hoạt động nào gần đây", color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
                } else {
                    recentActivities.forEach { activity ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .background(Color(0xFF4CAF50), shape = RoundedCornerShape(50))
                                )
                                Text(text = activity, color = Color.Black, style = MaterialTheme.typography.bodyMedium)
                            }
                            Text(text = "Done", color = Color.Gray, style = MaterialTheme.typography.labelSmall)
                        }
                    }
                }
            }
        }
    }
}
