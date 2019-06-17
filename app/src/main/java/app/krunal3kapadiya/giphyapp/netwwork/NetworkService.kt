package app.krunal3kapadiya.giphyapp.netwwork

import app.krunal3kapadiya.giphyapp.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */
object NetworkService {
    fun provideNetworkApi(): GiphyApi {
        val httpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
        }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory
                    .createWithScheduler(Schedulers.io())
            )
            .build()
            .create(GiphyApi::class.java)
    }
}