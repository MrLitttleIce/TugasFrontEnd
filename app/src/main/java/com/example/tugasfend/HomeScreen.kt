package com.example.tugasfend

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasfend.data.DummyData
import com.example.tugasfend.model.Aktris
import com.example.tugasfend.model.Aktor
import com.example.tugasfend.navigation.Screen
import com.example.tugasfend.component.AktorItem
import com.example.tugasfend.component.AktorItem
import com.example.tugasfend.component.AktrisItem

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    mentors: List<Aktor> = DummyData.dataAktor,
    mentees: List<Aktris> = DummyData.dataAktris,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(mentors, key = { it.id }) {
                    AktorItem(aktor = it) { mentorId ->
                        navController.navigate(Screen.Detail.route + "/$mentorId")
                    }
                }
            }
        }
        items(mentees, key = { it.id }) {
            AktrisItem(aktris = it, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}