package kh.com.sela.dev.homecontrol.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kh.com.sela.dev.homecontrol.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    var isChang by remember { mutableIntStateOf(0) }
    var menus = listOf<String>("Home","Devices","Energy","Setting")
    Scaffold(modifier = Modifier,
//        topBar = {
//
//                TopAppBar(
//                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
//                    title = {
//                        Row(
//                            horizontalArrangement = Arrangement.spacedBy(10.dp),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//
//                            IconButton({},
//                                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
//                                modifier = Modifier
//                            ) {
//                                Icon(painter = painterResource(R.drawable.ic_profile,),contentDescription = null,)
//                            }
//
//                            Text("Hi Sarina")
//                        }
//                    },
//                    modifier = Modifier,
//
//                    actions = {
//                        IconButton({},colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),) {Icon(painter = painterResource(R.drawable.ic_search),contentDescription = null) }
//                        IconButton({},colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),) {Icon(painter = painterResource(R.drawable.ic_notification),contentDescription = null) }
//                    },
//
//                    )
//
//
//        },


        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                menus.forEachIndexed { index, menu ->
                    NavigationBarItem(
                        selected = index==isChang,
                        onClick = {

                            isChang=index

                        },
                        icon = { when(menu){
                            "Home"->{Icon(painter = painterResource(R.drawable.ic_home,),contentDescription = null)}
                            "Devices"->{Icon(painter = painterResource(R.drawable.ic_device,),contentDescription = null)}
                            "Energy"->{Icon(painter = painterResource(R.drawable.ic_energy,),contentDescription = null)}
                            "Setting"->{Icon(painter = painterResource(R.drawable.ic_setting,),contentDescription = null)}
                        } },
                        modifier = Modifier,
                        enabled = true,
                        label = { Text(menu) },

                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = Color.Gray,
                            indicatorColor = Color.White,
                            unselectedTextColor = Color.Gray,
                            selectedTextColor = MaterialTheme.colorScheme.primary

                        ),

                        )
                }
            }
        }

        ) {paddingValues ->
        Column(modifier = Modifier
          //  .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .padding(paddingValues)) {
            SwitchScreen(index = isChang)
        }
    }
}
@Composable
fun SwitchScreen(index: Int){
   when(index){
       0->HomeScreen()
       1->DeviceScreen()
       2->EnergyScreen()
       3->SettingScreen()
   }
}