package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class Data(
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("slug")
    var slug: String? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("bitly_gif_url")
    var bitlyGifUrl: String? = null,
    @SerializedName("bitly_url")
    var bitlyUrl: String? = null,
    @SerializedName("embed_url")
    var embedUrl: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("source")
    var source: String? = null,
    @SerializedName("rating")
    var rating: String? = null,
    @SerializedName("content_url")
    var contentUrl: String? = null,
    @SerializedName("source_tld")
    var sourceTld: String? = null,
    @SerializedName("source_post_url")
    var sourcePostUrl: String? = null,
    @SerializedName("is_sticker")
    var isSticker: Int? = null,
    @SerializedName("import_datetime")
    var importDatetime: String? = null,
    @SerializedName("trending_datetime")
    var trendingDatetime: String? = null,
    @SerializedName("user")
    var user: User? = null,
    @SerializedName("images")
    var images: Images? = null,
    @SerializedName("title")
    var title: String? = null
//    @SerializedName("analytics")
//    var analytics: Analytics? = null
)