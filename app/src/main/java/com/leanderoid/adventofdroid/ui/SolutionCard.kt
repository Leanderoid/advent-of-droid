package com.leanderoid.adventofdroid.ui

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leanderoid.adventofdroid.R
import com.leanderoid.adventofdroid.solver.SolverStateManager
import com.leanderoid.adventofdroid.ui.theme.AdventOfDroidTheme

@Preview(name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    AdventOfDroidTheme {
        SolutionCard(
            SolverStateManager({ "Test" },
                image = R.drawable.ic_launcher_foreground)
        )
    }
}

@Composable
fun SolutionCard(msg: SolverStateManager) {
    Row(modifier = Modifier.padding(all = 20.dp)) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),

            painter = painterResource(id = msg.image),
            contentDescription = "Description"
        )
        Spacer(modifier = Modifier.width(28.dp))

        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        val solutionText by msg.solutionState.collectAsState()
        if (isExpanded) msg.calcSolution()

        val text = if (isExpanded) "${msg.description}\n${solutionText}" else msg.description
        println("Clicked, isExpanded = $isExpanded")
        // Toggle isExpanded when clicking on the Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.title,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp),
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}
