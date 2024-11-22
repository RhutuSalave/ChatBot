

package com.example.chatbot

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class ChatBotVM : ViewModel() {
    val list = mutableStateListOf<ChatData>()

    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = ApiKey
        )
    }

    fun sendMessage(message: String) = viewModelScope.launch {
        list.add(ChatData(message, ChatRoleEnum.USER.role))

        try {
            val chat = genAI.startChat()
            val response = chat.sendMessage(message).text ?: "Sorry, I couldn't process that."
            list.add(ChatData(response, ChatRoleEnum.MODEL.role))
        } catch (e: Exception) {
            list.add(ChatData("Error: Unable to fetch response.", ChatRoleEnum.MODEL.role))
        }
    }
}
