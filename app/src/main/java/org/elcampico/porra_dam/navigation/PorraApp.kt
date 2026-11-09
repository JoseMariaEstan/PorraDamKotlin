import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.elcampico.porra_dam.navigation.PantallaPrincipal
import org.elcampico.porra_dam.screens.PantallaBienvenida
import org.elcampico.porra_dam.ui.componentes.ConFondo

@Composable
fun PorraApp(modifier: Modifier = Modifier) {
    var alias by rememberSaveable { mutableStateOf<String?>(null) }

    ConFondo(modifier = modifier) {
        val actual = alias
        if (actual == null) {
            PantallaBienvenida(onEntrar = { nombre -> alias = nombre })
        } else {
            PantallaPrincipal(alias = actual)
        }
    }
}