package com.leanderoid.adventofdroid.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.leanderoid.adventofdroid.R

@Composable
fun Home(
    viewModel: HomeViewModel = viewModel()
) {
    val viewState by viewModel.state.collectAsState()

    val homeCategories = viewState.homeCategories
    val selectedHomeCategory = viewState.selectedHomeCategory

    Text(
        text = "Advent of Droid",
        modifier = Modifier
            .padding(all = 20.dp),
        color = if (selectedHomeCategory == HomeCategory.Year2020) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant
    )

    if (homeCategories.isNotEmpty()) {
        HomeCategoryTabs(
            categories = homeCategories,
            selectedCategory = selectedHomeCategory,
            onCategorySelected = viewModel::onHomeCategorySelected,
            modifier = Modifier.padding(top = 50.dp),
        )
    }

    LazyColumn(
        modifier = Modifier.padding(top = 100.dp)
    ) {
        items(viewState.solvers) { solverData ->
            SolutionCard(solverData)
        }
    }
}

@Composable
private fun HomeCategoryTabs(
    categories: List<HomeCategory>,
    selectedCategory: HomeCategory,
    onCategorySelected: (HomeCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedIndex = categories.indexOfFirst { it == selectedCategory }
    val selectionIndicator = @Composable { tabPositions: List<TabPosition> ->
        HomeTabMarker(
            Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
        )
    }

    TabRow(
        selectedTabIndex = selectedIndex,
        indicator = selectionIndicator,
        modifier = modifier
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onCategorySelected(category) },
                text = {
                    Text(
                        text = when (category) {
                            HomeCategory.Year2020 -> stringResource(R.string.year2020)
                            HomeCategory.Year2021 -> stringResource(R.string.year2021)
                        },
                        style = MaterialTheme.typography.body2
                    )
                }
            )
        }
    }
}

@Composable
fun HomeTabMarker(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface
) {
    Spacer(
        modifier
            .padding(horizontal = 22.dp)
            .height(5.dp)
            .background(color, RoundedCornerShape(topStartPercent = 100, topEndPercent = 100))
    )
}
