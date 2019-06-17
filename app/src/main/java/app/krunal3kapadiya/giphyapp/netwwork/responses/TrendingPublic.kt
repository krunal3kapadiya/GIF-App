package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class TrendingPublic(
    @SerializedName("data")
    @Expose
    var data: ArrayList<Data>? = null,
    @SerializedName("pagination")
    @Expose
    var pagination: Pagination? = null,
    @SerializedName("meta")
    @Expose
    var meta: Meta? = null
)
