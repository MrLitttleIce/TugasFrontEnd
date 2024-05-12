package com.example.tugasfend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBara() {
    val backgroundShape = MaterialTheme.shapes.extraLarge

    Row(
        modifier = Modifier
            .padding(start = 10.dp)
            .padding(end = 10.dp)
            .width(380.dp)
            .height(100.dp)
            .padding(vertical = 10.dp)
            .background(Color.White, backgroundShape),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Profile Section
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ds),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .width(60.dp)
                    .padding(start = 10.dp)
                    .clip(MaterialTheme.shapes.extraLarge), // Membuat frame bulat
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    "Hello",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold, // Teks menjadi tebal
                    fontSize = 18.sp // Ukuran font
                )
                Text(
                    "Lidia",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold, // Teks menjadi tebal
                    fontSize = 18.sp // Ukuran font
                )
            }

        }

        // Search Icon
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Search",
            tint = Color.Gray, // Mengubah warna ikon menjadi putih
            modifier = Modifier
                .size(50.dp)
                .padding(end = 10.dp)
        )
    }
}