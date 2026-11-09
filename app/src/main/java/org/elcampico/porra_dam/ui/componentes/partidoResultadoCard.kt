package org.elcampico.porra_dam.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.ui.theme.Porra_damTheme

@Composable
fun PartidoResultadoCard(
    nombreLocal: String,
    inicialesLocal: String,
    colorLocal: Color,
    golesLocal: Int?,              // null = aún no se ha jugado
    nombreVisitante: String,
    inicialesVisitante: String,
    colorVisitante: Color,
    golesVisitante: Int?,
    pronosticoLocal: Int?,         // null = sin pronóstico
    pronosticoVisitante: Int?,
    puntos: Int?,                  // null = sin puntos todavía
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                FilaResultado(nombreLocal, inicialesLocal, colorLocal, golesLocal)
                FilaResultado(nombreVisitante, inicialesVisitante, colorVisitante, golesVisitante)
                Text(
                    text = if (pronosticoLocal != null && pronosticoVisitante != null)
                        stringResource(R.string.tu_porra, pronosticoLocal, pronosticoVisitante)
                    else stringResource(R.string.sin_pronostico),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = puntos?.let { "+$it" } ?: "–",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = if ((puntos ?: 0) > 0) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun FilaResultado(nombre: String, iniciales: String, color: Color, goles: Int?) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        EscudoEquipo(iniciales, color, tamano = 28.dp)
        Text(nombre, modifier = Modifier.weight(1f))
        Text(goles?.toString() ?: "-", fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun PartidoResultadoCardPreview() {
    Porra_damTheme {
        PartidoResultadoCard(
        "Atlético Marina", "AM", Color(0xFFB3261E), 2,
        "Racing Costa", "RC", Color(0xFF1565C0), 1,
        pronosticoLocal = 2, pronosticoVisitante = 1, puntos = 8,
        modifier = Modifier.padding(16.dp)
    )
    }
}

