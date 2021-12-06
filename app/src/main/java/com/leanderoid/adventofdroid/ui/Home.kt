package com.leanderoid.adventofdroid.ui

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leanderoid.adventofdroid.ui.theme.AdventOfDroidTheme

@Composable
fun Home(
    viewModel: HomeViewModel = viewModel()
) {
    Text(
        text = "Advent of Droid",
        modifier = Modifier.padding(all = 20.dp)
    )
    LazyColumn(
        modifier = Modifier.padding(top = 40.dp)
    ) {
        items(viewModel.getSolvers()) { message ->
            MessageCard(message)
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    AdventOfDroidTheme {
        MessageCard(
            SolverData({ "Hey, take a look at Jetpack Compose, it's great!" },
            image = com.leanderoid.adventofdroid.R.drawable.ic_launcher_foreground)
        )
    }
}

@Composable
fun MessageCard(msg: SolverData) {
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

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

            val text = if (isExpanded) "${msg.description}\n${msg.invokeSolver()}" else msg.description

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.title,
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier.animateContentSize().padding(1.dp),
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    //maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

