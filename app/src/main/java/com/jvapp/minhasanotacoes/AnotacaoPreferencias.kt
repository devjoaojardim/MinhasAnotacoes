package com.jvapp.minhasanotacoes

import android.content.Context
import android.content.SharedPreferences

class AnotacaoPreferencias(private val context: Context) {
    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor
    private val NOME_ARQUIVO = "anotacao.preferencias"
    private val CHAVE_NOME = "nome"
    fun salvarAnotacao(anotacao: String?) {
        editor.putString(CHAVE_NOME, anotacao)
        editor.commit()
    }

    fun recuperarAnotacao(): String? {
        return preferences.getString(CHAVE_NOME, "")
    }

    init {
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0)
        editor = preferences.edit()
    }
}