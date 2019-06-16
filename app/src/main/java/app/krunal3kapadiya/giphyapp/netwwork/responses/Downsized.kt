package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class Downsized(
    @SerializedName("url")
    @Expose
    private val url: String? = null,
    @SerializedName("width")
    @Expose
    private val width: String? = null,
    @SerializedName("height")
    @Expose
    private val height: String? = null,
    @SerializedName("size")
    @Expose
    private val size: String? = null
)