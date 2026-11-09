package org.elcampico.porra_dam.screens

import android.R
import android.R.attr.fontWeight
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.elcampico.porra_dam.ui.componentes.EscudoEquipo
import org.elcampico.porra_dam.ui.componentes.PartidoCard
import org.elcampico.porra_dam.ui.theme.Porra_damTheme

@Composable
fun Jornada(
    alias: String,
    modifier: Modifier = Modifier
) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        Text(
//            text = "Jornada 2",
//            style = MaterialTheme.typography.headlineSmall,
//            fontWeight = FontWeight.Bold
//        )
//        Text(
//            text = "Hola, $alias. Pon tu pronóstico para cada partido.",
//            style = MaterialTheme.typography.bodyMedium,
//            color = MaterialTheme.colorScheme.onSurfaceVariant
//        )
//
//        TarjetaPartido("Atlético Marina", "AM", Color(0xFFB3261E), "UD Huerta", "UH", Color(0xFF2E7D32))
//        TarjetaPartido("Racing Costa", "RC", Color(0xFF1565C0), "Real Sierra", "RS", Color(0xFF6A1B9A))
//        TarjetaPartido("CF Albufera", "CA", Color(0xFFF9A825), "SD Olivar", "SO", Color(0xFF558B2F))
//        TarjetaPartido("Deportivo Faro", "DF", Color(0xFF00838F), "Unión Puerto", "UP", Color(0xFFD84315))
//        TarjetaPartido("CD Salinas", "CS", Color(0xFF37474F), "Club Almendro", "CL", Color(0xFF4E342E))
//
//        Button(
//            onClick = { /* de momento no hace nada */ },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp)
//        ) {
//            Icon(Icons.Default.Save, contentDescription = null)
//            Spacer(Modifier.width(8.dp))
//            Text("Guardar pronósticos", style = MaterialTheme.typography.titleMedium)
//        }
//    }
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Jornada 2")
        }
        items(partidos, key = {it.id}){partido ->
            PartidoCard(
                partido=partido,
                pronostico=pronosticos[partido.id]
            )
        }
    }
}

@Composable
private fun TarjetaPartido(
    local: String, inicialesLocal: String, colorLocal: Color,
    visitante: String, inicialesVisitante: String, colorVisitante: Color
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilaEquipo(local, inicialesLocal, colorLocal)
            FilaEquipo(visitante, inicialesVisitante, colorVisitante)
        }
    }
}

@Composable
private fun FilaEquipo(nombre: String, iniciales: String, color: Color) {
    var goles by rememberSaveable { mutableIntStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        EscudoEquipo(iniciales, color)
        Text(
            text = nombre,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.weight(1f)
        )
        FilledTonalIconButton(onClick = { goles-- }, enabled = goles > 0) {
            Icon(Icons.Default.Remove, contentDescription = "Quitar gol")
        }
        Text(
            text = "$goles",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(32.dp)
        )
        FilledTonalIconButton(onClick = { goles++ }, enabled = goles < 9) {
            Icon(Icons.Default.Add, contentDescription = "Añadir gol")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun JornadaPreview() {
    Porra_damTheme { Jornada(alias = "JM") }
}