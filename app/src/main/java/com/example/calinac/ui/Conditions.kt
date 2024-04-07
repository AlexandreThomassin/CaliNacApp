package com.example.calinac.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.R
import com.example.calinac.ui.theme.CaliNacTheme

@Composable
fun Conditions(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Nos conditions",
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
        Divider(
            color = colorResource(id = R.color.primary),
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
        )
        Card (
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.secondary)
            ),
            modifier = Modifier
                .padding(
                start = 15.dp,
                end = 15.dp,
            )
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Lapin",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()

                )
            }
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