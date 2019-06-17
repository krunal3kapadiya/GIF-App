package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("banner_url")
    val bannerUrl: String,
    @SerializedName("profile_url")
    val profileUrl: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("is_verified")
    val isVerified: Boolean
)