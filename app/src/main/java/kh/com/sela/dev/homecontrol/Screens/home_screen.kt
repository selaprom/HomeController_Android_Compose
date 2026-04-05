package kh.com.sela.dev.homecontrol.Screens

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.sela.dev.homecontrol.R
import kh.com.sela.dev.homecontrol.components.Chip
import kh.com.sela.dev.homecontrol.components.ItemGrid
import kh.com.sela.dev.homecontrol.components.TemperatureStatus
import androidx.compose.foundation.lazy.grid.rememberLazyGridState


data class ItemGridModel(
    val iconLeft: Int,
    val iconRight: Int,
    val label: String,
    val info: String,
    val device: String
)

val itemGridList = listOf(
    ItemGridModel(R.drawable.ic_lamp, R.drawable.ic_bluetooh, "Smart Lighting", "100% led light", "10 Devices"),
    ItemGridModel(R.drawable.ic_tv, R.drawable.ic_wifi, "Smart TV", "Used 8 kwh", "2 Devices"),
    ItemGridModel(R.drawable.ic_music, R.drawable.ic_bluetooh, "Refrigerator", "Used 5.2 kwh", "5 Devices"),
    ItemGridModel(R.drawable.ic_notification, R.drawable.ic_bluetooh, "Air Conditioner", "Used 9 kwh", "4 Devices"),
    ItemGridModel(R.drawable.ic_lamp, R.drawable.ic_bluetooh, "Heater", "OFF", "Bathroom"),
    ItemGridModel(R.drawable.ic_lamp, R.drawable.ic_bluetooh, "Lamp", "ON", "Desk"),
    ItemGridModel(R.drawable.ic_lamp, R.drawable.ic_bluetooh, "Speaker", "Playing", "Hall"),
    ItemGridModel(R.drawable.ic_lamp, R.drawable.ic_bluetooh, "Camera", "Active", "Garage"),
    ItemGridModel(R.drawable.ic_lamp, R.drawable.ic_bluetooh, "Door Lock", "Locked", "Front Door"),
    ItemGridModel(R.drawable.ic_lamp, R.drawable.ic_bluetooh, "Curtain", "Closed", "Bedroom")
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
var state= rememberScrollState()

    Column(
        modifier = Modifier
            //.background(color = MaterialTheme.colorScheme.primaryContainer)

            .padding(horizontal = 20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton({},
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
                modifier = Modifier
            ) {
                Icon(

                    painter = painterResource(R.drawable.ic_profile,),contentDescription = null,)
            }

            Text("Hi Sarina")
            Spacer(modifier = Modifier.weight(1f))
            IconButton({},colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),) {Icon(painter = painterResource(R.drawable.ic_search),contentDescription = null) }
            IconButton({},colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),) {Icon(painter = painterResource(R.drawable.ic_notification),contentDescription = null) }

        }
        Column() {
            Text("Control your", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Text("home Smartly", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }
        //TemperatureCard
        TemperatureStatus()
        //Chipbutton
        Chip()
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Connected devices")
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(5.dp))
                    .width(25.dp)
                    .height(25.dp)

            ) {
                Text("6", color = Color.White , fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Button({}, colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)) {
                Icon(painter = painterResource(R.drawable.ic_add),contentDescription = null)
                Text("ADD Device")
            }
        }
        ////GridView
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            userScrollEnabled = true,
            modifier = Modifier
                .height(800.dp)
                .weight(1f )

                ,

           // contentPadding = PaddingValues(10.dp),

            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),


        ) {
            items(
                items = itemGridList,

            ) { item ->

                ItemGrid(
                    iconleft = item.iconLeft,
                    iconright = item.iconRight,
                    label = item.label,
                    info = item.info,
                    device = item.device
                )
            }
        }


    }
}