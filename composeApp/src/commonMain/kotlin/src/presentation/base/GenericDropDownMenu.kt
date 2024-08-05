package presentation.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GenericDropDownMenu(
    options: List<DropDownDataItem>,
    selectedOption: DropDownDataItem,
    onSelectionChanged: (DropDownDataItem) -> Unit,
) {
    val expanded = remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.height(55.dp).fillMaxWidth().clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(BorderStroke(1.dp, Color(0xffEBEBEB)), RoundedCornerShape(8.dp))
            .clickable { expanded.value = !expanded.value },
    ) {
        Text(
            text = selectedOption.value,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 12.dp)
        )
        Icon(
            Icons.Rounded.ArrowDropDown,
            "",
            Modifier.padding(end = 12.dp).align(Alignment.CenterEnd)
        )
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        onSelectionChanged(selectionOption)
                        expanded.value = false
                    }) {
                    Text(text = selectionOption.value)
                }
            }
        }
    }
}

data class DropDownDataItem(
    val id: String,
    val value: String,
)