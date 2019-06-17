package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class DownsizedSmall(
    @SerializedName("width")
    @Expose
    private var width: String? = null,
    @SerializedName("height")
    @Expose
    private var height: String? = null,
    @SerializedName("mp4")
    @Expose
    private var mp4: String? = null,
    @SerializedName("mp4_size")
    @Expose
    private var mp4Size: String? = null
)