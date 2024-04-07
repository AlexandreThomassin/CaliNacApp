package com.example.calinac

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calinac.ui.Account
import com.example.calinac.ui.AccountViewModel
import com.example.calinac.ui.Adopt
import com.example.calinac.ui.Homepage
import com.example.calinac.ui.theme.CaliNacTheme
import com.example.calinac.ui.component.Header
import com.example.calinac.ui.component.Footer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calinac.ui.Conditions
import com.example.calinac.ui.Events
import com.example.calinac.ui.HelpUs
import com.example.calinac.ui.Partnerships
import com.example.calinac.ui.Shop
import kotlinx.coroutines.launch

enum class CaliNacScreen() {
    Home,
    Account,
    Adopt,
    Conditions,
    Help,
    Partnerships,
    Events,
    Shop
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaliNacTheme {
                // A surface container using the 'background' color from the theme
                CaliNacApp()
            }
        }
    }
}

@Composable
fun CaliNacApp(
    viewModel: AccountViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { Header(
            goToHome = { navController.navigate( CaliNacScreen.Home.name ) },
            goToAccount = { navController.navigate(CaliNacScreen.Account.name) },
            openDrawer = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }

        )},
        bottomBar = { Footer() }
    ) { innerPadding ->
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier
                        .padding(vertical = 50.dp)
                        .width(250.dp),
                    drawerContainerColor = colorResource(id = R.color.secondary),
                    drawerContentColor = colorResource(id = R.color.secondary),
                    drawerShape = RectangleShape
                ) {

                    var selectedItem by remember{
                        mutableStateOf("")
                    }

                    Text(
                        text = "Informations",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                    )
                    Divider(
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    NavigationDrawerItem(
                        label = { Text(text = "Nos conditions") },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Info"
                            )
                        },
                        selected = selectedItem == CaliNacScreen.Conditions.name,
                        onClick = {
                            navController.navigate(CaliNacScreen.Conditions.name)
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                            selectedItem = CaliNacScreen.Conditions.name

                        },
                        shape = RectangleShape,
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = colorResource(id = R.color.secondary),
                            selectedContainerColor = colorResource(id = R.color.primary)
                        )
                    )

                    NavigationDrawerItem(
                        label = { Text(text = "Nous aider") },
                        icon = {
                            Icon(
                                painterResource(id = R.drawable.baseline_volunteer_activism_24),
                                contentDescription = "Help us !"
                            )
                        },
                        selected = selectedItem == CaliNacScreen.Help.name,
                        onClick = {
                            navController.navigate(CaliNacScreen.Help.name)
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                            selectedItem = CaliNacScreen.Help.name
                        },
                        shape = RectangleShape,
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = colorResource(id = R.color.secondary),
                            selectedContainerColor = colorResource(id = R.color.primary)
                        )
                    )

                    NavigationDrawerItem(
                        label = { Text(text = "Partenariat") },
                        icon = {
                            Icon(
                                painterResource(id = R.drawable.baseline_handshake_24),
                                contentDescription = "Help us !"
                            )
                        },
                        selected = selectedItem == CaliNacScreen.Partnerships.name,
                        onClick = {
                            navController.navigate(CaliNacScreen.Partnerships.name)
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                            selectedItem = CaliNacScreen.Partnerships.name
                        },
                        shape = RectangleShape,
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = colorResource(id = R.color.secondary),
                            selectedContainerColor = colorResource(id = R.color.primary)
                        )
                    )

                    NavigationDrawerItem(
                        label = { Text(text = "Événements") },
                        icon = {
                            Icon(
                                painterResource(id = R.drawable.baseline_local_activity_24),
                                contentDescription = "Help us !"
                            )
                        },
                        selected = selectedItem == CaliNacScreen.Events.name,
                        onClick = {
                            navController.navigate(CaliNacScreen.Events.name)
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                            selectedItem = CaliNacScreen.Events.name
                        },
                        shape = RectangleShape,
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = colorResource(id = R.color.secondary),
                            selectedContainerColor = colorResource(id = R.color.primary)
                        )
                    )

                    NavigationDrawerItem(
                        label = { Text(text = "Boutique") },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "Help us !"
                            )
                        },
                        selected = selectedItem == CaliNacScreen.Shop.name,
                        onClick = {
                            navController.navigate(CaliNacScreen.Shop.name)
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                            selectedItem = CaliNacScreen.Shop.name
                        },
                        shape = RectangleShape,
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = colorResource(id = R.color.secondary),
                            selectedContainerColor = colorResource(id = R.color.primary)
                        )
                    )

                }
            },
        ) {

            val uiState by viewModel.uiState.collectAsState()

            NavHost(
                navController = navController,
                startDestination = CaliNacScreen.Home.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = CaliNacScreen.Home.name) {
                    Homepage(
                        goToAdopt = { navController.navigate(CaliNacScreen.Adopt.name) }
                    )
                }
                composable(route = CaliNacScreen.Account.name) {
                    Account(
                        state = uiState,
                        profilModel = viewModel
                    )
                }
                composable(route = CaliNacScreen.Adopt.name) {
                    Adopt()
                }

                composable(route = CaliNacScreen.Conditions.name){
                    Conditions()
                }

                composable(route = CaliNacScreen.Help.name){
                    HelpUs()
                }

                composable(route = CaliNacScreen.Partnerships.name){
                    Partnerships()
                }

                composable(route = CaliNacScreen.Events.name){
                    Events()
                }

                composable(route = CaliNacScreen.Shop.name){
                    Shop()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    CaliNacTheme {
        Header({})
    }
}



@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    CaliNacTheme {
        Footer()
    }
}