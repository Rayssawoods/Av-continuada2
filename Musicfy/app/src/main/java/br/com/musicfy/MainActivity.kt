package br.com.musicfy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import android.widget.Toast
import br.com.musicfy.http.MusicApi
import br.com.musicfy.models.Music
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val novoTv = TextView(baseContext)


        ll_conteudo.addView(novoTv)

        consumirApiMusicas()
    }


    fun consumirApiMusicas() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://5f907b7ee0559c0016ad69ee.mockapi.io/musicfy-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        //É criada a implementação em tempo real da Api
        val requests = retrofit.create(MusicApi::class.java)



        //getFilmes é o endpoits que retorna uma call --preparação da chamada da api
        val callMusic = requests.getMusics()

        callMusic.enqueue(object: Callback<List<Music>> {
            override fun onFailure(call: Call<List<Music>>, t: Throwable) {
                Toast.makeText(applicationContext, "Deu ruim $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Music>>, response: Response<List<Music>>) {
                response.body()?.forEach {
                    val novoTv = TextView(baseContext)

                    novoTv.text = "${it.id} - ${it.nome} - ${it.artista} -${it.album}"
                    novoTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
                    novoTv.setTextColor(Color.parseColor("#000000"))

                    ll_conteudo.addView(novoTv)
                }
            }

        })

    }
}