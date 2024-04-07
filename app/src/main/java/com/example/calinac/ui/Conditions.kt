package com.example.calinac.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.R
import com.example.calinac.ui.theme.CaliNacTheme

@Composable
fun Conditions(
    onBack: () -> Unit = {}
){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp,
                    start = 5.dp,
                    end = 5.dp
                )
        ) {
            IconButton(
                onClick = onBack,
                modifier = Modifier
                    .size(25.dp)
            ) {
                Icon(
                    Icons.Sharp.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text(
                text = "Nos Conditions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Icon(
                Icons.Sharp.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .alpha(0f)
            )
        }
        Divider(
            color = colorResource(id = R.color.primary),
            thickness = 2.dp,
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 20.dp
                )
        )

        conditionCard(
            title = "Lapin",
            description = "Vie en duo, de sexes opposés (chacun est stérilisé) - Semi-liberté enclos 2m² par lapin ou totale liberté. Vie en intérieur exclusivement. Tous nos lapins partent vaccinés, identifiés et stérilisés.",
            food = "Foin à volonté + verdure quotidienne",
            price = "Lapine 160€ / lapin 150€ / couple de lapins 280€"
        )
        conditionCard(
            title = "Cochon d'inde",
            description = "Vie  en duo de même sexe (ou en groupe pour les femelles) - Cage ou enclos  de 7000cm² minimum pour 2. Vie en intérieur principalement, nous  étudions les dossiers au cas par cas pour les adoptions en extérieur.",
            food = "Foin à volonté + verdure quotidienne",
            price = "solo 25€ / duo : 40€"
        )
        conditionCard(
            title = "Hamster",
            description = "Vie strictement solitaire - Cage ou cuve de 5000cm² minimum",
            food = "Mélange de graines et céréales + foin",
            price = "10€"
        )
        conditionCard(
            title = "Gerbille",
            description = "Vie en duo ou groupe - Cage ou cuve de 6000cm² minimum pour 2",
            food = "Mélange de graines et céréales + foin",
            price = "15€ solo / 30€ duo / 40€ trio"
        )
        conditionCard(
            title = "Souris",
            description = "Vie  solitaire pour le mâle dans un habitat de 4000cm² minimum / Vie en  groupe pour les femelles dans un habitat de 5000cm² minimum pour deux  souris",
            food = "Mélange de graines et céréales + foin",
            price = "10€ solo / 15€ duo / 20€ un trio"
        )
    }
}

@Composable
fun conditionCard(
    title: String,
    description: String,
    food: String,
    price: String
) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.secondary)
        ),
        modifier = Modifier
            .padding(bottom = 16.dp)
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()

            )
            Divider(
                thickness = 2.dp,
                color = colorResource(id = R.color.primary),
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Text(
                text = description,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
            DashedDivider(
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp, vertical = 5.dp)
            )
            Text(
                text = "Alimentation",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = food,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
            DashedDivider(
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp, vertical = 5.dp)
            )
            Text(
                text = "Frais",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = price,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConditionsPreview(){
    CaliNacTheme {
        Conditions()
    }
}