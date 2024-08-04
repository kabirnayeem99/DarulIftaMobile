package src.presentation.theme

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import daruliftamobile.composeapp.generated.resources.Res
import daruliftamobile.composeapp.generated.resources.notonastaliqurdu_bold
import daruliftamobile.composeapp.generated.resources.notonastaliqurdu_medium
import daruliftamobile.composeapp.generated.resources.notonastaliqurdu_regular
import daruliftamobile.composeapp.generated.resources.notonastaliqurdu_semibold


@Composable
fun NotoNastaliqUrduFontFamily() = FontFamily(
    Font(Res.font.notonastaliqurdu_regular, weight = FontWeight.Light),
    Font(Res.font.notonastaliqurdu_regular, weight = FontWeight.Normal),
    Font(Res.font.notonastaliqurdu_medium, weight = FontWeight.Medium),
    Font(Res.font.notonastaliqurdu_semibold, weight = FontWeight.SemiBold),
    Font(Res.font.notonastaliqurdu_bold, weight = FontWeight.Bold),
)



