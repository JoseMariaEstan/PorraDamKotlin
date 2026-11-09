package org.elcampico.porra_dam.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.elcampico.porra_dam.ui.componentes.EscudoEquipo
import org.elcampico.porra_dam.ui.theme.Porra_damTheme

@Composable
fun Resultados(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Jornada 1",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Has sumado 12 puntos",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // ---- Resultados fijos: cambia aquí lo que quieras ----
        TarjetaResultado(
            local = "Atlético Marina", inicialesLocal = "AM", colorLocal = Color(0xFFB3261E), golesLocal = "2",
            visitante = "Racing Costa", inicialesVisitante = "RC", colorVisitante = Color(0xFF1565C0), golesVisitante = "1",
            tuPorra = "Tu porra: 2 - 1", puntos = "+8"
        )
        TarjetaResultado(
            local = "UD Huerta", inicialesLocal = "UH", colorLocal = Color(0xFF2E7D32), golesLocal = "0",
            visitante = "CF Albufera", inicialesVisitante = "CA", colorVisitante = Color(0xFFF9A825), golesVisitante = "0",
            tuPorra = "Tu porra: 1 - 1", puntos = "+2"
        )
        TarjetaResultado(
            local = "Real Sierra", inicialesLocal = "RS", colorLocal = Color(0xFF6A1B9A), golesLocal = "3",
            visitante = "Deportivo Faro", inicialesVisitante = "DF", colorVisitante = Color(0xFF00838F), golesVisitante = "1",
            tuPorra = "Tu porra: 2 - 0", puntos = "+2"
        )
        TarjetaResultado(
            local = "SD Olivar", inicialesLocal = "SO", colorLocal = Color(0xFF558B2F), golesLocal = "1",
            visitante = "CD Salinas", inicialesVisitante = "CS", colorVisitante = Color(0xFF37474F), golesVisitante = "2",
            tuPorra = "No hiciste pronóstico", puntos = "–"
        )
        TarjetaResultado(
            local = "Unión Puerto", inicialesLocal = "UP", colorLocal = Color(0xFFD84315), golesLocal = "-",
            visitante = "Club Almendro", inicialesVisitante = "CL", colorVisitante = Color(0xFF4E342E), golesVisitante = "-",
            tuPorra = "Tu porra: 1 - 1 · aún no se ha jugado", puntos = "–"
        )
    }
}

@Composable
private fun TarjetaResultado(
    local: String, inicialesLocal: String, colorLocal: Color, golesLocal: String,
    visitante: String, inicialesVisitante: String, colorVisitante: Color, golesVisitante: String,
    tuPorra: String,
    puntos: String
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                FilaResultado(local, inicialesLocal, colorLocal, golesLocal)
                FilaResultado(visitante, inicialesVisitante, colorVisitante, golesVisitante)
                Text(
                    text = tuPorra,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = puntos,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun FilaResultado(nombre: String, iniciales: String, color: Color, goles: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        EscudoEquipo(iniciales, color, tamano = 28.dp)
        Text(
            text = nombre,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = goles,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ResultadosPreview() {
    Porra_damTheme { Resultados() }
}