package com.kevinhomorales.vertexaikotlinjetpackcompose.main.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevinhomorales.vertexaikotlinjetpackcompose.helpers.VertexAIHelper
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var response by mutableStateOf("La respuesta aparecerá aquí")
        private set
    var isLoading by mutableStateOf(false)
        private set

    fun askVertexAI(question: String) {
        if (question.isBlank()) return
        isLoading = true
        viewModelScope.launch {
            response = VertexAIHelper().generateTextFromGemini(question)
            isLoading = false
        }
    }
}