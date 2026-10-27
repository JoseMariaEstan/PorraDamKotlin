package org.elcampico.porra_dam.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.elcampico.porra_dam.ui.componentes.FondoPantalla
import org.elcampico.porra_dam.ui.theme.Porra_damTheme

@Composable
fun PantallaBienvenida(
    onEntrar: (alias: String) -> Unit,
    modifier: Modifier = Modifier
) {
    PantallaSala(
        onEntrar = { alias, _ -> onEntrar(alias) },
        modifier = modifier
    )
}

@Composable
fun PantallaSala(
    onEntrar: (alias: String, sala: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var alias by rememberSaveable { mutableStateOf("") }
    var sala by rememberSaveable { mutableStateOf("") }
    Box(modifier = modifier.fillMaxSize()) {
        FondoPantalla()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Porra ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFFA5FFCF))) {
                        append("DAM")
                    }
                },
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 55.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Pronostica los partidos de cada jornada y compite con tu clase.\n¿Quién acertará más?",
                color = Color.White.copy(alpha = 0.85f),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.92f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Tu alias",
                        color = Color.Black.copy(alpha = 0.85f),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(5.dp)
                    )
                    OutlinedTextField(
                        value = alias,
                        onValueChange = { alias = it },
                        label = { Text("Escribe tu nombre o alias") },
                        leadingIcon = {
                            Icon(Icons.Default.Person, contentDescription = null)
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Sala",
                        color = Color.Black.copy(alpha = 0.85f),
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Black
                    )
                    OutlinedTextField(
                        value = sala,
                        onValueChange = { sala = it },
                        label = { Text("p. ej. 1A - DAM - 2026") },
                        leadingIcon = {
                            Icon(Icons.Default.People, contentDescription = null)
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                    Button(
                        onClick = { onEntrar(alias, sala) },
                        enabled = alias.isNotBlank() && sala.isNotBlank(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                        )
                    ) {
                        Text(
                            text = "Entrar en la porra ->",
                            fontSize = 20.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(20.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PantallaSalaPreview() {
    Porra_damTheme {
        PantallaSala(onEntrar = { _, _ -> })
    }
}
