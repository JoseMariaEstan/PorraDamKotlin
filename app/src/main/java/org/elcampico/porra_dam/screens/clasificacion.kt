package org.elcampico.porra_dam.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.elcampico.porra_dam.ui.theme.Porra_damTheme

@Composable
fun Clasificacion(
    alias: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Clasificación general",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "10 participantes",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // ---- Clasificación fija: cambia aquí posiciones, nombres y puntos ----
        FilaClasificacion(1, "Lucía", 34)
        FilaClasificacion(2, "Hugo", 31)
        FilaClasificacion(3, "Martina", 30)
        FilaClasificacion(4, "Pablo", 28)
        FilaClasificacion(5, alias, 26, esYo = true)
        FilaClasificacion(6, "Sara", 25)
        FilaClasificacion(7, "Álex", 22)
        FilaClasificacion(8, "Paula", 19)
        FilaClasificacion(9, "Adrián", 15)
        FilaClasificacion(10, "Carmen", 12)
    }
}

@Composable
private fun FilaClasificacion(
    posicion: Int,
    nombre: String,
    puntos: Int,
    esYo: Boolean = false
) {
    val fondo = if (esYo) MaterialTheme.colorScheme.primaryContainer else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(fondo)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$posicion",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = if (esYo) "$nombre (tú)" else nombre,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (esYo) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "$puntos pts",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ClasificacionPreview() {
    Porra_damTheme { Clasificacion(alias = "JM") }
}