package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.model.BottomButtons
import com.example.myapplication.navegacion.navigation
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = { TopAppBarContent() },
                        bottomBar = { BottomAppBarContent(navController) }) {

                        navigation(navController)
                    }

                }


            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent() {
    TopAppBar(
        title = { Text(text = "Lanzamientos") },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Gray),
        actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Buscar")
            }
        }

    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarContent(navController: NavController) {
    var selectedItemIndex by rememberSaveable() {
        mutableStateOf(0)
    }
    NavigationBar {
        val items = listOf(
            BottomButtons(
                menu = "Menu",
                title = "Menu",
                selectedItem = Icons.Filled.Person,
                unSelectedItem = Icons.Outlined.Person
            ),
            BottomButtons(
                menu="SneakerRecyclerView",
                title = "Sneaker",
                selectedItem = Icons.Filled.Person,
                unSelectedItem = Icons.Outlined.Person
            ),
            BottomButtons(
                menu="RecyclerViewCloth",
                title = "Cloth",
                selectedItem = Icons.Filled.Person,
                unSelectedItem = Icons.Outlined.Person
            )
        )
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected =  selectedItemIndex==index,
                onClick = {selectedItemIndex = index
                          navController.navigate(item.menu)},



                {
                    Icon(imageVector =if(index== selectedItemIndex) {
                        item.selectedItem
                    }else item.unSelectedItem,
                        contentDescription = item.title)
                },
                label = { Text(text = item.title) },)




                    }

            }
        }


