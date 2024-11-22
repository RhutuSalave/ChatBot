

package com.example.chatbot.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatbot.ChatData
import com.example.chatbot.ChatRoleEnum

@Composable
fun ChatList(list: MutableList<ChatData>) {
    LazyColumn {
        items(list) { chat ->
            val backgroundColor = if (chat.role == ChatRoleEnum.USER.role) Color.Black else Color.LightGray
            val textColor = if (chat.role == ChatRoleEnum.USER.role) Color.White else Color.Black

            Text(
                text = chat.message,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
                    .padding(12.dp),
                color = textColor,
                fontSize = 16.sp
            )
        }
    }
}

