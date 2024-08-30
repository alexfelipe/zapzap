package br.com.alexf.zapzap.features.chatsList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alexf.zapzap.ui.theme.ZapZapTheme

@Composable
fun ChatsListScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // search text field
            Row(
                Modifier
                    .clip(CircleShape)
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(16.dp)
            ) {
                Icon(Icons.Default.Search, contentDescription = null)
                Spacer(Modifier.size(8.dp))
                Text("Search...")
            }
            Spacer(Modifier.size(16.dp))
            // chats filter
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                val filters = remember {
                    mutableStateListOf("All", "Unread", "Groups")
                }
                filters.forEach { filter ->
                    Box(
                        Modifier
                            .clip(CircleShape)
                            .background(Color.Gray)
                            .padding(16.dp, 8.dp)
                    ) {
                        Text(filter)
                    }
                }
            }
        }
        items(10) {
            val avatarSize = 54.dp
            Row(Modifier.fillMaxWidth()) {
                Box(
                    Modifier
                        .size(avatarSize)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(Modifier.size(16.dp))
                Column(
                    Modifier.heightIn(avatarSize),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("chat name")
                        Text("last message date")
                    }
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(Modifier.weight(1f)) {
                            Icon(Icons.Default.DoneAll, contentDescription = null)
                            Spacer(Modifier.size(4.dp))
                            Text("last message")
                        }
                        Box(
                            Modifier
                                .clip(CircleShape)
                                .background(Color.Green)
                                .padding(8.dp, 4.dp)
                        ) {
                            Text("99")
                        }
                    }
                }
            }
        }
        // chats list
    }

}

@Preview
@Composable
private fun ChatsListScreenPreview() {
    ZapZapTheme {
        Surface {
            ChatsListScreen()
        }
    }
}