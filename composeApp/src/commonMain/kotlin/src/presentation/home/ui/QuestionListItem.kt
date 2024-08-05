package src.presentation.home.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import src.domain.entity.QuestionAnswer

@Composable
fun QuestionListItem(modifier: Modifier = Modifier, question: QuestionAnswer) {
    Card(modifier = modifier.padding(horizontal = 12.dp).fillMaxWidth()) {
        Row(modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
            Spacer(Modifier.width(8.dp))
            Text(
                question.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,

                    ),
                modifier = Modifier.weight(0.80F),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 26.sp,
            )
            Spacer(Modifier.width(8.dp))
            Text(
                question.id.toString() + " " + "نمبر",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.End,
                ),
                lineHeight = 26.sp,
                modifier = Modifier.weight(0.20F)
            )
            Spacer(Modifier.width(8.dp))
        }
    }
}