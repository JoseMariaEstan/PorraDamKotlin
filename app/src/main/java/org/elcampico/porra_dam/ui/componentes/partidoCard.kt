package org.elcampico.porra_dam.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.elcampico.porra_dam.ui.theme.Porra_damTheme

@Composable
fun PartidoCard(
    nombreLocal: String,
    inicialesLocal: String,
    colorLocal: Color,
    golesLocal: Int,
    onCambioLocal: (Int) -> Unit,
    nombreVisitante: String,
    inicialesVisitante: String,
    colorVisitante: Color,
    golesVisitante: Int,
    onCambioVisitante: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FilaEquipoSelector(nombreLocal, inicialesLocal, colorLocal, golesLocal, onCambioLocal)
            HorizontalDivider()
            FilaEquipoSelector(nombreVisitante, inicialesVisitante, colorVisitante, golesVisitante, onCambioVisitante)
        }
    }
}

@Composable
private fun FilaEquipoSelector(
    nombre: String,
    iniciales: String,
    color: Color,
    goles: Int,
    onCambio: (Int) -> Unit
) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        EscudoEquipo(iniciales, color)
        Spacer(Modifier.width(12.dp))
        Text(
            text = nombre,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
        MarcadorSelector(goles = goles, onCambio = onCambio)
    }
}
@Preview(showBackground = true, widthDp = 360)
@Composable
private fun PartidoCardPreview() {
    Porra_damTheme {
        PartidoCard(
            nombreLocal = "Atlético Marina",
            inicialesLocal = "AM",
            colorLocal = Color(0xFFB3261E),
            golesLocal = 2,
            onCambioLocal = {},
            nombreVisitante = "Racing Costa",
            inicialesVisitante = "RC",
            colorVisitante = Color(0xFF1565C0),
            golesVisitante = 1,
            onCambioVisitante = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}