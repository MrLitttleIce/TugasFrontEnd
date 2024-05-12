package com.example.tugasfend

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tugasfend.data.DummyData
import com.example.tugasfend.model.Aktor

@Composable
fun DetailAktorScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    aktorId: Int?
) {
    val newAktorList = DummyData.dataAktor.filter { aktor ->
        aktor.id == aktorId
    }
    Column(
        modifier = modifier
    ) {
        DetailAktorContent(newAktorList = newAktorList)
    }
}

@Composable
private fun DetailAktorContent(
    newAktorList : List<Aktor>,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = newAktorList[0].photo)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(height = 250.dp, width = 170.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentDescription = " Poster "
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = newAktorList[0].name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "(${newAktorList[0].nickname})",
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = "Role : ${newAktorList[0].role}",
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DetailAktorContentPreview() {
    DetailAktorContent(newAktorList = DummyData.dataAktor)
}