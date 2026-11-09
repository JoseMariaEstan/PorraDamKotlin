package org.elcampico.porra_dam.ui.componentes

import org.elcampico.porra_dam.ui.theme.Porra_damTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MarcadorSelector(
    goles: Int,
    onCambio: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilledTonalIconButton(
            onClick = { onCambio(goles - 1) },
            enabled = goles > 0,
            modifier = Modifier.size(32.dp)
        ) { Text("−", style = MaterialTheme.typography.titleMedium) }

        Text(
            text = goles.toString(),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(28.dp)
        )

        FilledTonalIconButton(
            onClick = { onCambio(goles + 1) },
            modifier = Modifier.size(32.dp)
        ) { Text("+", style = MaterialTheme.typography.titleMedium) }
    }
}

@Preview(showBackground = true)
@Composable
private fun MarcadorSelectorPreview() {
    Porra_damTheme { MarcadorSelector(goles = 2, onCambio = {}) }
}