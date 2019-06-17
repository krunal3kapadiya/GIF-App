package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class Meta(
    @SerializedName("status")
    private var status: Int? = null,
    @SerializedName("msg")
    private var msg: String? = null,
    @SerializedName("response_id")
    private var responseId: String? = null
)