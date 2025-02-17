package br.com.musicfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    }

    fun irAdicionarMusica(component:View){
        val addMusicaActivity = Intent(this@MainActivity, AddMusic::class.java)
        startActivity(addMusicaActivity)
    }

    fun irBuscarMusicas(component:View){
        val myMusicListActivity = Intent(this@MainActivity, MyMusicList::class.java)
        startActivity(myMusicListActivity)
    }

}