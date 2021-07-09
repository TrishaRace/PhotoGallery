package com.trisharace.core.di

import com.trisharace.core.platform.NetworkHandler
import com.trisharace.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { NetworkHandler(get()) }
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
    }
}

private fun createClient(): OkHttpClient {


    val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder().apply {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        this.addInterceptor(loggingInterceptor)

        addInterceptor { chain ->
            val newUrl = chain.request().url
                .newBuilder()
                .addQueryParameter("client_id", BuildConfig.PUBLIC_KEY)
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .build()
            chain.proceed(newRequest)

        }
    }

    return okHttpClientBuilder.build()
}
