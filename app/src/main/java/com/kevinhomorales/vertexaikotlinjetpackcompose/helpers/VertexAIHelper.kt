package com.kevinhomorales.vertexaikotlinjetpackcompose.helpers

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.vertexai.vertexAI

class VertexAIHelper {

    // Inicializar el modelo de Vertex AI en Firebase
    private val vertexAI = Firebase.vertexAI
    private val model = vertexAI.generativeModel("gemini-2.0-flash")

    suspend fun generateTextFromGemini(prompt: String): String {
        return try {
            val response = model.generateContent(prompt)
            response.text ?: "No se generó respuesta."
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}