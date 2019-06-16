package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class Pagination(
    @SerializedName("total_count")
    @Expose
    private var totalCount: Int? = null,
    @SerializedName("count")
    @Expose
    private var count: Int? = null,
    @SerializedName("offset")
    @Expose
    private var offset: Int? = null
)