package com.aifitness.domain.model

data class PoseDetectionConfig(

    val trackedAngles: List<JointAngle>,

    val repStartThreshold: Float,

    val repEndThreshold: Float,

    val confidenceThreshold: Float = 0.7f,

    val mirrorMode: Boolean = false
)