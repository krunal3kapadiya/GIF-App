package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class DownsizedMedium(
    @SerializedName("url")
    @Expose
    private var url: String? = null,
    @SerializedName("width")
    @Expose
    private var width: String? = null,
    @SerializedName("height")
    @Expose
    private var height: String? = null,
    @SerializedName("size")
    @Expose
    private var size: String? = null

)