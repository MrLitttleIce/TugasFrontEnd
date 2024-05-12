package com.example.tugasfend.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfend.R
import com.example.tugasfend.model.Film
import com.example.tugasfend.ui.theme.TugasfendTheme

@Composable
fun FilmItem(
    film: Film,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = film.photo),
            contentDescription = film.name,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = film.name,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = film.genre,
            textAlign = TextAlign.Center,
            color = when (film.genre) {
                "Beginner" -> Color.Red
                "Fundamental" -> Color.Yellow
                "Intermediate" -> Color.Green
                else -> MaterialTheme.colorScheme.primary
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun CourseItemPreview() {
    TugasfendTheme {
        FilmItem(
            film = Film(
                1,
                "nobar ",
                "kny s1-s4",
                R.drawable.kny1
            )
        )
    }
}
