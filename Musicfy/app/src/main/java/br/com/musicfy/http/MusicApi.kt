package br.com.musicfy.http

import br.com.musicfy.models.Music
import retrofit2.Call
import retrofit2.http.GET

interface MusicApi {

    @GET("/musics")
    fun getMusics(

    ): Call<List<Music>>
}