package br.com.bandtec.fragmentado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_fragmento_forte.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentoForte.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentoForte : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_forte, container, false)
    }

    // esta método é invocando sempre que o fragmento é criado!
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // recuperando os parâmetros enviados pela Activity
        val nomeRecebido = arguments?.getString("usuario")
        val idadeRecebida = arguments?.getLong("idade")

        // obtendo parâmetros do tipo "data class"
        val cadastro =
            arguments?.getSerializable("cadastro") as Cadastro

        val texto = """
        Então, $nomeRecebido, com $idadeRecebida anos 
        você já deveria saber o que quer da vida!
        """.trimIndent()

        tv_forte.text = texto
        // quem atualizou o Android Studio terá que fazer a linha abaixo
        //activity?.findViewById<TextView>(R.id.tv_forte)?.text = texto
    }
}