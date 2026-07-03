package com.aifitness.domain.model

data class JointAngle(

    val name: String,

    val startLandmark: Int,

    val middleLandmark: Int,

    val endLandmark: Int,

    val minAngle: Float,

    val maxAngle: Float
)