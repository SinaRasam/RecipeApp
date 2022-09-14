package com.example.recipeapp.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object AnimationList {

    //Pulse Animation
    @Composable
    fun Pulsating(pulseFraction: Float = 1.2f, content: @Composable () -> Unit) {
        val infiniteTransition = rememberInfiniteTransition()

        val scale by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = pulseFraction,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        Box(modifier = Modifier.scale(scale)) {
            content()
        }
    }

    @Composable
    fun PulseItem() {
        Pulsating {
            Surface(
                color = MaterialTheme.colors.primary,
                shape = CircleShape,
                modifier = Modifier.size(100.dp),
                content = {}
            )
            Image(
                imageVector = Icons.Default.Favorite,
                "",
                modifier = Modifier.size(100.dp)
            )
        }
    }

    //Shimmer 1
    @Composable
    fun ShimmerAnimation1() {
        val shimmerColorShades = listOf(

            Color.LightGray.copy(0.9f),

            Color.LightGray.copy(0.2f),

            Color.LightGray.copy(0.9f)

        )

        val transition = rememberInfiniteTransition()
        val translateAnim by transition.animateFloat(
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 1200, easing = FastOutLinearInEasing),
                RepeatMode.Reverse
            )
        )

        val brush = Brush.linearGradient(
            colors = shimmerColorShades,
            start = Offset(10f, 10f),
            end = Offset(translateAnim, translateAnim)
        )

        ShimmerItem(brush = brush)

    }

    @Composable
    fun ShimmerItem(brush: Brush) {
        Column(modifier = Modifier.padding(16.dp)) {
            Surface(shape = MaterialTheme.shapes.medium) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(250.dp)
                        .background(brush = brush)
                )
            }

            Surface(shape = MaterialTheme.shapes.medium) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .padding(vertical = 8.dp)
                        .background(brush = brush)
                )
            }

        }
    }

    //Shimmer 2
    @Composable
    fun ShimmerAnimation2() {

        val gradient = listOf(
            Color.LightGray.copy(alpha = 0.9f), //darker grey (90% opacity)
            Color.LightGray.copy(alpha = 0.3f), //lighter grey (30% opacity)
            Color.LightGray.copy(alpha = 0.9f)
        )

        val transition = rememberInfiniteTransition() // animate infinite times

        val translateAnimation = transition.animateFloat( //animate the transition
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000, // duration for the animation
                    easing = FastOutLinearInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        val brush = linearGradient(
            colors = gradient,
            start = Offset(200f, 200f),
            end = Offset(
                x = translateAnimation.value,
                y = translateAnimation.value
            )
        )
        ShimmerGridItem(brush = brush)
    }

    @Composable
    fun ShimmerGridItem(brush: Brush) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp), verticalAlignment = Alignment.Top
        ) {

            Spacer(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(brush)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.5f)
                        .background(brush)
                )

                Spacer(modifier = Modifier.height(10.dp)) //creates an empty space between
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.7f)
                        .background(brush)
                )

                Spacer(modifier = Modifier.height(10.dp)) //creates an empty space between
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth(fraction = 0.9f)
                        .background(brush)
                )
            }
        }
    }


}