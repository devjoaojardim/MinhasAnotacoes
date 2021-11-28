package com.jvapp.minhasanotacoes


import androidx.appcompat.app.AppCompatActivity
import com.jvapp.minhasanotacoes.AnotacaoPreferencias
import android.widget.EditText
import android.os.Bundle
import com.jvapp.minhasanotacoes.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var preferencias: AnotacaoPreferencias? = null
    private var editAnotacao: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editAnotacao = findViewById(R.id.editAnotacao)
        preferencias = AnotacaoPreferencias(applicationContext)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener { view ->

            val textRecuperado = editAnotacao!!.getText().toString()
            if (textRecuperado == "") {
                Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show()
            } else {
                preferencias!!.salvarAnotacao(textRecuperado)
                Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show()
            }
        }

        //Recuoera anotacao
        val anotacao = preferencias!!.recuperarAnotacao()
        if (anotacao != "") {
            editAnotacao!!.setText(anotacao)

        }
    }
}