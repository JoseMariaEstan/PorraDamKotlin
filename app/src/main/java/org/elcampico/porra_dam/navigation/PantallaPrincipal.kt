package org.elcampico.porra_dam.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.elcampico.porra_dam.screens.Jornada
import org.elcampico.porra_dam.screens.Resultados

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(alias: String, modifier: Modifier = Modifier) {
    var pestanas by rememberSaveable { mutableStateOf(Pestanas.JORNADA) }

    BackHandler(pestanas != Pestanas.JORNADA) {
        pestanas = Pestanas.JORNADA
    }
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text(pestanas.titulo) }) },
        bottomBar = {
            NavigationBar {
                Pestanas.entries.forEach { p ->
                    NavigationBarItem(
                        selected = pestanas == p,
                        onClick = { pestanas = p },
                        icon = { Icon(p.icono, contentDescription = null) },
                        label = { Text(p.titulo) }
                    )
                }
            }
        }
    ) { innerPadding ->
        val m = Modifier.padding(innerPadding)
        when (pestanas) {
            Pestanas.JORNADA -> Jornada(modifier = m, alias = alias)
            Pestanas.RESULTADOS -> Resultados(modifier = m)
        }
    }
}
