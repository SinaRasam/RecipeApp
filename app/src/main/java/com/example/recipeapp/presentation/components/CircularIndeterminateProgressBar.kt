package com.example.recipeapp.presentation.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import androidx.constraintlayout.widget.Constraints

@Composable
fun CircularIndeterminateProgressBar(
    isDisplayed: Boolean
) {
    if (isDisplayed) {
        
        BoxWithConstraints(modifier=Modifier.fillMaxSize()) {
            val constraints = if(minWidth<600.dp){
                myDecoupledConstraints(0.3f)
            }
            else{
                myDecoupledConstraints(0.7f)
            }
            ConstraintLayout(
                modifier = Modifier.fillMaxSize(),
                constraintSet = constraints
            ) {

                CircularProgressIndicator(
                    modifier = Modifier.layoutId("progressBar"),
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = "Loading...",
                    modifier = Modifier.layoutId("text"),
                    color = MaterialTheme.colors.primary
                )
            }//ConstraintLayout End

        }

    }
}

private fun myDecoupledConstraints(verticalBias:Float): ConstraintSet {
    return ConstraintSet{
        val guideline = createGuidelineFromTop(verticalBias)
        val progressBar = createRefFor("progressBar")
        val text = createRefFor("text")

        constrain(progressBar){
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(text){
            top.linkTo(progressBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}

/*
ConstraintLayout(
modifier = Modifier.fillMaxSize(),
) {
    val (progressBar, text) = createRefs()
    val topGuideline = createGuidelineFromTop(0.3f)

    CircularProgressIndicator(
        modifier = Modifier.constrainAs(progressBar) {
            top.linkTo(topGuideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        },
        color = MaterialTheme.colors.primary
    )
    Text(
        text = "Loading...",
        modifier = Modifier.constrainAs(text) {
            top.linkTo(progressBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        },
        color = MaterialTheme.colors.primary
    )
}//ConstraintLayout End
*/
