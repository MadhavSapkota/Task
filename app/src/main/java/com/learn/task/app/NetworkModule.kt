package com.learn.task.app
import android.content.Context
import com.learn.task.apputlis.ApiConstants
import com.learn.task.apputlis.HttpsClient
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

@Module
open class NetworkModule {

    @AppScope
    @Provides
    fun cache(context: Context): okhttp3.Cache {
        return okhttp3.Cache(
            File(context.cacheDir, ApiConstants.HTTP_DIR_CACHE),
            ApiConstants.CACHE_SIZE.toLong()
        )
    }

    @AppScope
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor=HttpLoggingInterceptor()
        httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    fun okHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: okhttp3.Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(Inceptor())
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }

    @AppScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        val gson=GsonBuilder().setExclusionStrategies().create()

        return Retrofit.Builder().client(HttpsClient.getCAsafeOkHttpClient())
            .baseUrl(Apiurl.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @AppScope
    @Provides
    fun webservice(retrofit: Retrofit): Webservice {
        return retrofit.create(Webservice::class.java)
    }
}
