package com.example.chatbot.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp




import androidx.compose.foundation.layout.fillMaxWidth


@Composable
fun ChatFooter(onClick: (text: String) -> Unit) {
    var inputText by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
//            .background(Color.LightGray)
            .background(Color.DarkGray)
            .padding(10.dp)
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            placeholder = { Text(text = "Enter your question") },
            singleLine = true,
            modifier = Modifier.weight(1f)
        )

        IconButton(onClick = {
            onClick(inputText)
            inputText = ""
        }) {
            Icon(
                Icons.Rounded.Send,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black, shape = CircleShape)
                    .padding(8.dp),
                tint = Color.White
            )
        }
    }
}

