package br.com.bandtec.fragmentado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // associar ao onclique do botão "suave"
    fun trazerEnsinamentoSuave(componente:View) {
        // Sempre começar com supportFragmentManager.beginTransaction()
        // depois, no replace(<id do frame>, <instância do Fragment desejado>)
        // ao final, sempre o .commit() para efetivar a troca

        // "limpando" o fr_ensinamento
        fr_ensinamento.removeAllViews()
        // findViewById<FrameLayout>(R.id.fr_ensinamento).removeAllViews()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_ensinamento, FragmentoSuave()).commit()
    }

    // associar ao onclique do botão "forte"
    fun trazerEnsinamentoForte(componente:View) {
        // "limpando" o fr_ensinamento
        fr_ensinamento.removeAllViews()

        // preparando parâmetros para a Fragment com uma Bundle
        // uma Bundle nos permite enviar valores da uma Activity p/ uma Fragment
        val parametros = Bundle()
        // nos putX(<NOME do dado>, <VALOR do dado>)
        parametros.putString("usuario", "Zé Ruela")
        parametros.putLong("idade", System.currentTimeMillis())

        // passando parâmetros do tipo "data class"
        // OBS: a data class deve implementar "Serializable"
        val cadastro =
            Cadastro("Maria", 20, 70.0, true)
        parametros.putSerializable("cadastro", cadastro)

        // instanciando um objeto do tipo FragmentoForte
        val fragmento = FragmentoForte()

        // definindo os parâmetros do fragmento
        fragmento.arguments = parametros

        // trocando o fragmento que está no 'fr_ensinamento'
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_ensinamento, fragmento).commit()
    }


}