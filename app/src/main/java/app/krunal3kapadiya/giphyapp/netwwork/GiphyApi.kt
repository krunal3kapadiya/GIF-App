package app.krunal3kapadiya.giphyapp.netwwork

import app.krunal3kapadiya.giphyapp.netwwork.responses.TrendingPublic
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

interface GiphyApi {
    @GET("gifs/trending")
    fun getTrendingPublicApi(@Query("api_key") apiKey: String): Observable<TrendingPublic>
}