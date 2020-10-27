package br.com.musicfy.http

import br.com.musicfy.models.Music
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MusicApi {

    @GET("/musics")
    fun getMusics(

    ): Call<List<Music>>

    @POST("/musics")
    fun postMusica(@Body novaMusica: Music): Call<Void>
}