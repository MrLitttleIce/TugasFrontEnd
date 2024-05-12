package com.example.tugasfend

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfend.ui.theme.TugasfendTheme
import com.example.tugasfend.data.DummyData
import com.example.tugasfend.model.Film
import com.example.tugasfend.component.FilmItem

@Composable
fun CourseScreen(
    modifier: Modifier = Modifier,
    courses: List<Film> = DummyData.datafilm
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Adaptive(140.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(courses, key = { it.id }) {
            FilmItem(film = it)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CourseScreenPreview() {
    TugasfendTheme {
        CourseScreen(courses = DummyData.datafilm)
    }
}