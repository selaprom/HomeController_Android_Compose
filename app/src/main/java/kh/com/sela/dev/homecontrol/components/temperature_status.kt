package kh.com.sela.dev.homecontrol.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kh.com.sela.dev.homecontrol.R


data class Temperature(val label: String, val temperature: String, val icon: Int,val color: Color)
val temperatureList = listOf(
    Temperature(
        "Temp", "26°C", R.drawable.ic_airplan, color = Color.Red),
    Temperature("Humidity", "32°C", R.drawable.ic_water, color = Color.Blue),
    Temperature("Energy", "22°C", R.drawable.ic_electric, color = Color.Yellow)
)
@Composable
fun TemperatureStatus(){
    Box(
        modifier = Modifier
            .height(75.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            temperatureList.forEachIndexed {index,  item->
                if (index==1){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.width(1.dp).background(color = Color.White).height(30.dp)
                        )
                        Spacer(modifier = Modifier.width(28.dp))
                        temperature(
                            label = item.label,
                            temperature = item.temperature,
                            icon = item.icon,
                            color = item.color
                        )
                        Spacer(modifier = Modifier.width(28.dp))
                        Box(
                            modifier = Modifier.width(1.dp).background(color = Color.White).height(30.dp)
                        )
                    }
                }
                else{
                    temperature(
                        label = item.label,
                        temperature = item.temperature,
                        icon = item.icon,
                        color = item.color
                    )
                }
            }
        }
    }
}
@Composable
fun temperature(label: String,temperature: String,icon: Int,color: Color){
    Row(

        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(icon,),contentDescription = null, tint = color)
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(label, color = Color.White)
            Text(temperature, color = Color.White)
        }
    }
}