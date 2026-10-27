package org.elcampico.porra_dam.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import org.elcampico.porra_dam.R

@Composable
fun FondoPantalla(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.fondo_pantalla_hd),
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
