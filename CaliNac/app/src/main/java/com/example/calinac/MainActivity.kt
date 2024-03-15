package com.example.calinac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calinac.ui.theme.CaliNacTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaliNacTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Header()
                        Footer()
                    }
                }
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.primary)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Icon(
            Icons.Outlined.Menu,
            contentDescription = "Menu",
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp)
        )
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
        )
        Icon(
            Icons.Outlined.AccountCircle,
            contentDescription = "Account",
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    CaliNacTheme {
        Header()
    }
}

@Composable
fun Footer() {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.primary)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondary),
                contentColor = colorResource(id = R.color.black)
            ),
            contentPadding = PaddingValues(vertical = 5.dp, horizontal = 25.dp),
            modifier = Modifier
                .width(275.dp)
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(R.string.footer_contact_text),
                fontSize = 12.sp,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(end = 10.dp)
        ) {
            Icon(
                painterResource(id = R.drawable.icons8_instagram_96___),
                contentDescription = "Menu",
                modifier = Modifier
                    .size(45.dp)
                    .padding(horizontal = 5.dp)
            )
            Icon(
                painterResource(id = R.drawable.icons8_facebook_96___),
                contentDescription = "Account",
                modifier = Modifier
                    .size(45.dp)
                    .padding(horizontal = 5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    CaliNacTheme {
        Footer()
    }
}