package com.example.tugasfend.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfend.R
import com.example.tugasfend.model.Aktor
import com.example.tugasfend.ui.theme.TugasfendTheme

@Composable
fun AktorItem(
    aktor: Aktor,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(aktor.id)
        }
    ) {
        Image(
            painter = painterResource(id = aktor.photo),
            contentDescription = aktor.name, modifier = Modifier
                .size(80.dp)
        )
        Text(
            text = aktor.name,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
        Text(
            text = aktor.role,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MentorItemHorizontalPreview() {
    TugasfendTheme {
        AktorItem(
            aktor = Aktor(1, "coki", "cok", "darkhumor", R.drawable.coki),
            onItemClicked = { mentorId ->
                println("Mentor Id : $mentorId")
            }
        )
    }
}