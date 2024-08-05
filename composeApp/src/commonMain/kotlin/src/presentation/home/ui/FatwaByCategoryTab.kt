package src.presentation.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import src.domain.entity.QuestionAnswer

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FatwaByCategoryTab(questions: List<QuestionAnswer>) {


    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.padding(top = 20.dp),
    ) {
        items(
            questions,
            key = { q -> q.id },
        ) { question ->
            QuestionListItem(
                modifier = Modifier.animateItemPlacement(),
                question = question,
            )
        }
    }
}