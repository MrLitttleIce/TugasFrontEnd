package com.example.tugasfend.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasfend.model.Aktris
import com.example.tugasfend.R
import com.example.tugasfend.ui.theme.TugasfendTheme

@Composable
fun AktrisItem(
    aktris: Aktris,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = aktris.photo),
            contentDescription = aktris.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = aktris.name, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = aktris.role, color = MaterialTheme.colorScheme.primary)
                Text(text = " - ${aktris.batch}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MentorItemPreview() {
    TugasfendTheme {
        AktrisItem(
            aktris = Aktris(
                1,
                "Nama Mentee",
                R.drawable.no_profile,
                "Batch 7",
                "Mentee Mobile"
            )
        )
    }
}