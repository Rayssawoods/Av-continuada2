package br.com.musicfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.musicfy.http.MusicApi
import br.com.musicfy.models.Music
import kotlinx.android.synthetic.main.activity_add_music.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddMusic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_music)
    }

    fun irSalvarMusica(component: View) {

        val album = et_album.text.toString()

        when {
            et_nome_musica.text.isBlank() -> {
                et_nome_musica.error = getString(R.string.nome_blank)
                et_nome_musica.requestFocus()

            }
            et_artista.text.isBlank() -> {
                et_artista.error = getString(R.string.artista_blank)
                et_artista.requestFocus()

            }
            et_album.text.isBlank() -> {
                et_album.error = getString(R.string.album_blank)
                et_album.requestFocus()

            }
            else -> {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://5f907b7ee0559c0016ad69ee.mockapi.io/musicas/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val requests = retrofit.create(MusicApi::class.java)

                val novaMusica = Music(
                    null,
                    et_nome_musica.text.toString(),
                    et_artista.text.toString(),
                    et_album.text.toString()
                )

                val callAddMusic = requests.postMusica(novaMusica)

                callAddMusic.enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(
                            baseContext,
                            getString(R.string.txt_erro_cadastrado),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        Toast.makeText(
                            baseContext,
                            getString(R.string.txt_cadastrado) + response.code(),
                            Toast.LENGTH_SHORT
                        ).show()

                        limpar()
                    }
                })
            }
        }
    }

    fun limpar() {
        et_nome_musica.requestFocus()
        et_nome_musica.setText("")
        et_artista.setText("")
        et_album.setText("")

    }
}