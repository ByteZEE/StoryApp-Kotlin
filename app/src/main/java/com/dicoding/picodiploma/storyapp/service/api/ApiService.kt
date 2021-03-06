package com.dicoding.picodiploma.storyapp.service.api

import com.dicoding.picodiploma.storyapp.service.response.AddStoryResponse
import com.dicoding.picodiploma.storyapp.service.response.LoginResponse
import com.dicoding.picodiploma.storyapp.service.response.RegisterResponse
import com.dicoding.picodiploma.storyapp.service.response.StoriesResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun postRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("stories")
   suspend fun getStories(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<StoriesResponse>

    @Multipart
    @POST("stories")
    fun postStory(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody
    ):Call<AddStoryResponse>

    @GET("stories")
    fun getListStoryLocation(
        @Header("Authorization") token: String,
        @Query("location") loc: Int = 1
    ): Call<StoriesResponse>

}