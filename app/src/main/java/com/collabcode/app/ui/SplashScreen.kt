package com.collabcode.app.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(onFinish: () -> Unit) {
    val cc = LocalCC.current
    val scale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(dampingRatio = 0.8f, stiffness = 150f)
    )
    val alpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(800, delayMillis = 200)
    )
    val textAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(600, delayMillis = 600)
    )

    LaunchedEffect(Unit) {
        delay(2000)
        onFinish()
    }

    Box(
        Modifier.fillMaxSize().background(cc.bg),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // App icon / logo placeholder
            Box(
                Modifier
                    .size(120.dp)
                    .graphicsLayer { scaleX = scale; scaleY = scale; this.alpha = alpha }
                    .background(cc.accent, androidx.compose.ui.graphics.CornerRadius(28.dp))
            ) {
                // You can add an icon here later
            }

            Text(
                "CollabCode",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = cc.text.copy(alpha = textAlpha),
                letterSpacing = 1.2.sp
            )

            Text(
                "Build Android apps from your phone",
                fontSize = 14.sp,
                color = cc.muted.copy(alpha = textAlpha)
            )
        }
    }
}