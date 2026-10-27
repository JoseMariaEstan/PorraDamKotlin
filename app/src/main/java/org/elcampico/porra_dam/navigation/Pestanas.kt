package org.elcampico.porra_dam.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector

enum class Pestanas(val titulo: String, val icono: ImageVector) {
    JORNADA("Jornada", Icons.Default.DateRange),
    RESULTADOS("Resultados", Icons.Default.CheckCircle),
}