package app.storytel.candidate.com.data_remote

import app.storytel.candidate.com.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClientFactory {

    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun provideOkHttpClient() =
        OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor()).build()

    fun provideApi(retrofit: Retrofit): Services = retrofit.create(Services::class.java)

}