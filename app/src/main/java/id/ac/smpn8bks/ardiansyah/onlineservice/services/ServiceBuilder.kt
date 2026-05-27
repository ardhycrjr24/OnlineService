package id.ac.smpn8bks.ardiansyah.onlineservice.services

import id.ac.smpn8bks.ardiansyah.onlineservice.helpers.Config
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {

    // Create logger
    private val logger: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY
        )

    // Create okhttp client
    private val okHttp: OkHttpClient.Builder =
        OkHttpClient.Builder()
            .callTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(logger)

    // Create retrofit builder
    private val builder: Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .client(okHttp.build())

    // Create retrofit instance
    private val retrofit: Retrofit =
        builder.build()

    fun <T> buildService(
        serviceType: Class<T>
    ): T {

        return retrofit.create(serviceType)
    }
}