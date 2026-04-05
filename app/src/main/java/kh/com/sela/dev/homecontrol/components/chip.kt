package kh.com.sela.dev.homecontrol.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kh.com.sela.dev.homecontrol.R

data class ChipItem(val icon: Int, val label: String, val color: Color)
val chipList = listOf(
    ChipItem(
        icon = R.drawable.ic_energy,
        label = "Living room",
        color = Color(0xFF2196F3)
    ),
    ChipItem(
        icon = R.drawable.ic_setting,
        label = "Bedroom",
        color = Color(0xFF4CAF50)
    ),
    ChipItem(
        icon = R.drawable.ic_device,
        label = "Kitchen",
        color = Color(0xFFF44336)
    ),
    ChipItem(
        icon = R.drawable.ic_water,
        label = "Alerts",
        color = Color(0xFFFF9800)
    ),
    ChipItem(
        icon = R.drawable.ic_electric,
        label = "Profile",
        color = Color(0xFF9C27B0)
    )
)
@Composable
fun Chip(){
    var isChang by remember { mutableIntStateOf(0) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.horizontalScroll(state = rememberScrollState())

    ) {

        chipList.forEachIndexed { index ,item->
            AssistChip(

                onClick = { isChang=index },
                label = {Text(item.label)},
                modifier = Modifier.height(40.dp),
                enabled = true,
                leadingIcon = { Icon(painter = painterResource(item.icon),contentDescription = null, tint = item.color) },

                border =
                    if ( index==isChang){
                        BorderStroke(width = 1.dp, color = Color.Blue)
                    }else{
                        null
                    },
                colors = AssistChipDefaults.assistChipColors(containerColor = Color.White)


                )

        }
    }
}
