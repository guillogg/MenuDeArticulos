package com.example.myapplication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.model.Sneaker
import com.example.myapplication.navegacion.AppScreens


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SneakerRecyclerView(navController: NavHostController) {
    val sneaker: Map<String, List<Sneaker>> = getSneakers().groupBy { it.modelo }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        sneaker.forEach { (modelo, mySneaker) ->
            stickyHeader {
                Text(
                    text = modelo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            items(mySneaker) { sneaker ->
                Card(
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier
                        .clickable {

                            navController.navigate(

                                route = AppScreens.SneakerDetails.route+ "/${sneaker.sneakername}/${sneaker.modelo}/${sneaker.colorway}/${sneaker.precioRetail}/${sneaker.photo}"
                            )



                        }
                        .padding(top = 8.dp, bottom = 8.dp, end = 16.dp, start = 16.dp)
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = sneaker.photo),
                            contentDescription = "Foto de la shanta",
                            Modifier.fillMaxWidth(),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = sneaker.sneakername,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontSize = 15.sp
                        )
                        Text(
                            text = sneaker.modelo,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontSize = 15.sp
                        )
                        Text(
                            text = sneaker.colorway,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontSize = 15.sp
                        )
                        Text(
                            text = sneaker.precioRetail,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}
fun getSneakers(): List<Sneaker> {
    return listOf(
        Sneaker(
            "April",
            "Dunk Low Sb",
            "TURBO GREENMETALLIC SILVERTURBO GREEN",
            "$120",
            R.drawable.dunk_sb_april
        ), Sneaker(
            "Supreme",
            "Dunk low Sb",
            "BLACK BLACK MULTI COLOR",
            "$138",
            R.drawable.dunk_sb_supreme
        ), Sneaker(
            "Yuto Horigome",
            "Dunk Low Sb",
            "WOLF GREY IRON GREY SAIL",
            "$130",
            R.drawable.dunk_sb_yuto
        ),
        Sneaker(
            "Concord",
            "Jordan 1 Low",
            "WHITE BLACK",
            "$120",
            R.drawable.jordan1_low_conrd
        ),
        Sneaker(
            "Jordan 1 low",
            "Travis Scott Olive",
            "SAIL - UNIVERSITY RED BLACK-MEDIUM OLIVE",
            "$150",
            R.drawable.jordan1_low_olive
        ),
        Sneaker(
            "Jordan 1 High",
            "Travis Scott Mocha",
            "SAILBLACK-DARK MOCHA UNIVERSITY RED",
            "$175",
            R.drawable.jordan_1_ts_mocha
        ),
        Sneaker(
            "Jordan 3",
            "A Ma Maniere",
            "WHITE MEDIUM GREYVIOLET ORE WHITE",
            "$200",
            R.drawable.jordan_3_a_ma_maniere
        ),
        Sneaker(
            "Jordan 3",
            "Fragment",
            "WHITE WHITEBLACK",
            "$200",
            R.drawable.jordan_3_fragment
        ),
        Sneaker(
            "Jordan 4",
            "A Ma Maniere",
            "VIOLET OREMEDIUM ASH BLACKMUSLINBURGUNDY CRUSH",
            "$225",
            R.drawable.jordan_4_a_ma_maniere
        ),
        Sneaker(
            "Jordan 4",
            "Cactus Jack",
            "UNIVERSITY BLUEBLACKVARSITY RED",
            "$225",
            R.drawable.jordan_4_ts
        )
    )

}