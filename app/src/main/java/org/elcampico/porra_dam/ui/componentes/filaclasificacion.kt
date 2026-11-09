package org.elcampico.porra_dam.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.elcampico.porra_dam.R
import org.elcampico.porra_dam.ui.theme.Porra_damTheme

@Composable
fun FilaClasificacion(
    posicion: Int,
    alias: String,
    puntos: Int,
    esYo: Boolean,
    modifier: Modifier = Modifier
) {
    val primario = MaterialTheme.colorScheme.primary
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = if (esYo) primario.copy(alpha = 0.12f) else MaterialTheme.colorScheme.surface,
        contentColor = if (esYo) primario else MaterialTheme.colorScheme.onSurface
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = posicion.toString(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.width(32.dp)
            )
            Text(
                text = alias,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = if (esYo) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = stringResource(R.string.puntos, puntos),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun FilaClasificacionPreview() {
    Porra_damTheme{FilaClasificacion(2, "JM", 30, esYo = true, modifier = Modifier.padding(16.dp)) }
}