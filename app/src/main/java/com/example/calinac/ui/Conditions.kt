package com.example.calinac.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Conditions(
    onBack: () -> Unit = {}
){

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val list = listOf("Lapin", "Cochon d'inde", "Hamster", "Gerbille", "Souris")

    var selectedItem by remember {
        mutableStateOf(list[0])
    }



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

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {isExpanded = !isExpanded},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = colorResource(id = R.color.primary),
                    focusedIndicatorColor = colorResource(id = R.color.primary),
                    unfocusedContainerColor = colorResource(id = R.color.secondary),
                    focusedContainerColor = colorResource(id = R.color.secondary)
                ),
                trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}
            )
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier
                    .exposedDropdownSize()
            )
            {
                list.forEachIndexed{index, text ->
                    DropdownMenuItem(
                        text = { Text(text = list[index], modifier = Modifier.fillMaxWidth()) },
                        onClick = {
                            selectedItem = list[index]
                            isExpanded = false
                        },
                        colors = MenuDefaults.itemColors(
                            trailingIconColor = colorResource(id = R.color.primary),
                            leadingIconColor = colorResource(id = R.color.primary)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Divider(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
                DropdownMenuItem(
                    text = { Text(text = "Devenir famille d'acceuil", modifier = Modifier.fillMaxWidth()) },
                    onClick = {
                        selectedItem = "Devenir famille d'acceuil"
                        isExpanded = false
                    },
                    colors = MenuDefaults.itemColors(
                        trailingIconColor = colorResource(id = R.color.primary),
                        leadingIconColor = colorResource(id = R.color.primary)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                DropdownMenuItem(
                    text = { Text(text = "Nous confier votre animal", modifier = Modifier.fillMaxWidth()) },
                    onClick = {
                        selectedItem = "Nous confier votre animal"
                        isExpanded = false
                    },
                    colors = MenuDefaults.itemColors(
                        trailingIconColor = colorResource(id = R.color.primary),
                        leadingIconColor = colorResource(id = R.color.primary)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        when (selectedItem){
            "Lapin" -> {
                conditionCard(
                    title = "Lapin",
                    description = "Vie en duo, de sexes opposés (chacun est stérilisé) - Semi-liberté enclos 2m² par lapin ou totale liberté. Vie en intérieur exclusivement. Tous nos lapins partent vaccinés, identifiés et stérilisés.",
                    food = "Foin à volonté + verdure quotidienne",
                    price = "Lapine 160€ / lapin 150€ / couple de lapins 280€"
                )
            }
            "Cochon d'inde" -> {
                conditionCard(
                    title = "Cochon d'inde",
                    description = "Vie  en duo de même sexe (ou en groupe pour les femelles) - Cage ou enclos  de 7000cm² minimum pour 2. Vie en intérieur principalement, nous  étudions les dossiers au cas par cas pour les adoptions en extérieur.",
                    food = "Foin à volonté + verdure quotidienne",
                    price = "solo 25€ / duo : 40€"
                )
            }
            "Hamster" -> {
                conditionCard(
                    title = "Hamster",
                    description = "Vie strictement solitaire - Cage ou cuve de 5000cm² minimum",
                    food = "Mélange de graines et céréales + foin",
                    price = "10€"
                )
            }
            "Gerbille" -> {
                conditionCard(
                    title = "Gerbille",
                    description = "Vie en duo ou groupe - Cage ou cuve de 6000cm² minimum pour 2",
                    food = "Mélange de graines et céréales + foin",
                    price = "15€ solo / 30€ duo / 40€ trio"
                )
            }
            "Souris" -> {
                conditionCard(
                    title = "Souris",
                    description = "Vie  solitaire pour le mâle dans un habitat de 4000cm² minimum / Vie en  groupe pour les femelles dans un habitat de 5000cm² minimum pour deux  souris",
                    food = "Mélange de graines et céréales + foin",
                    price = "10€ solo / 15€ duo / 20€ un trio"
                )
            }
            "Devenir famille d'acceuil" -> {
                conditionCard(
                    title = "Devenir famille d'acceuil",
                    description = "Mêmes  conditions de vie que pour l'adoption d'un animal. Contact avec  les autres animaux (chiens, chats) sous surveillance. ",
                    food = "",
                    price = "Frais vétérinaires  et matériel pris en charge par l'association. Litière et alimentation à  la charge de la FA. Adhésion annuelle obligatoire de 15€."
                )
            }
            "Nous confier votre animal" -> {
                conditionCard(
                    title = "Nous confier votre animal",
                    description = "Nous récupérons uniquement les lapins, cochons d'inde, hamsters, gerbilles et souris. Pour  les cessions de lapins, une participation de 15€ sera demandée en amont  de la recherche de famille d'accueil, pour éviter tout désistement par  la suite. Une fois l'animal confié à l'association, il n'est plus  possible de le récupérer.",
                    food = "",
                    price = "15€ pour les lapins."
                )
            }
        }
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

            if (food != ""){
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
            }

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