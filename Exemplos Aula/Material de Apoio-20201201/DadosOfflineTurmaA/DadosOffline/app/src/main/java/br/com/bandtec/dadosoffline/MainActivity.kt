package br.com.bandtec.dadosoffline

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // SharedPreferences é a classe que gerencia dados locais no dispositivo
    // São dados simples, não um banco de dados completo
    var preferencias: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getPreferences() recupera as 'preferências' do app
        // o MODE_PRIVATE como o nome sugere, indica que somente este App terá acesso
        preferencias = getPreferences(Context.MODE_PRIVATE)

        // getX() recuperam um dado das preferências
        // o 1º argumento - NOME do dado
        // o 2º argumento - Valor padrão, caso o dado não exista
        val usuario = preferencias?.getString("usuario",null)

        if (usuario != null) {
            // o que fazer se já existir usuário nos "dados offline"?
            // vou para a 2ª tela direto!
            startActivity(Intent(this, Tela2::class.java))
        }
    }

    fun entrar(componente:View) {

        // findViewById<Switch>(R.id.sw_lembrar).isChecked
        if (sw_lembrar.isChecked) {

            // .edit() retorna um Editor
            // com um objeto desse tipo podemos ir incluindo/alterando dados nas 'preferencias'
            val editor = preferencias?.edit()

            // putX() - Inclui ou altera um dado
            // o 1º argumento - NOME do dado
            // o 2º argumento - VALOR do dado
            editor?.putString("usuario", et_usuario.text.toString())
            // findViewById<EditText>(R.id.et_usuario).text.toString()

            // o commit() salva os dados na memória interna
            editor?.commit()
            // editor?.apply() // é como o commit(), porém assíncrono
        }

        startActivity(Intent(this, Tela2::class.java))
    }
}