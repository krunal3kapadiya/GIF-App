package app.krunal3kapadiya.giphyapp.netwwork.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

data class Images(
//    @SerializedName("fixed_height_still")
//    val fixedHeightStill: FixedHeightStill,
//    @SerializedName("original_still")
//    val originalStill: OriginalStill,
//    @SerializedName("fixed_width")
//    val fixedWidth: FixedWidth,
//    @SerializedName("fixed_height_small_still")
//    val fixedHeightSmallStill: FixedHeightSmallStill,
//    @SerializedName("fixed_height_downsampled")
//    val fixedHeightDownsampled: FixedHeightDownsampled,
    @SerializedName("preview")
    val preview: Preview,
//    @SerializedName("fixed_height_small")
//    val fixedHeightSmall: FixedHeightSmall,
//    @SerializedName("downsized_still")
//    val downsizedStill: DownsizedStill,
    @SerializedName("downsized")
    val downsized: Downsized,
    @SerializedName("downsized_large")
    val downsizedLarge: DownsizedLarge,
//    @SerializedName("fixed_width_small_still")
//    val fixedWidthSmallStill: FixedWidthSmallStill,
//    @SerializedName("preview_webp")
//    val previewWebp: PreviewWebp,
//    @SerializedName("fixed_width_still")
//    val fixedWidthStill: FixedWidthStill,
//    @SerializedName("fixed_width_small")
//    val fixedWidthSmall: FixedWidthSmall,
    @SerializedName("downsized_small")
    val downsizedSmall: DownsizedSmall,
//    @SerializedName("fixed_width_downsampled")
//    val fixedWidthDownsampled: FixedWidthDownsampled,
    @SerializedName("downsized_medium")
    val downsizedMedium: DownsizedMedium,
    @SerializedName("original")
    val original: Original
//    @SerializedName("fixed_height")
//    val fixedHeight: FixedHeight,
//    @SerializedName("looping")
//    val looping: Looping,
//    @SerializedName("original_mp4")
//    val originalMp4: OriginalMp4,
//    @SerializedName("preview_gif")
//    val previewGif: PreviewGif,
//    @SerializedName("480w_still")
//    val _480wStill: _480wStill,
)

data class Original(
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("frames")
    val frames: String,
    @SerializedName("mp4")
    val mp4: String,
    @SerializedName("mp4_size")
    val mp4Size: String,
    @SerializedName("webp")
    val webp: String,
    @SerializedName("webp_size")
    val webpSize: String,
    @SerializedName("hash")
    val hash: String
)

data class Preview(
    @SerializedName("width")
    @Expose
    val width: String,
    @SerializedName("height")
    @Expose
    val height: String,
    @SerializedName("mp4")
    @Expose
    val mp4: String,
    @SerializedName("mp4_size")
    @Expose
    val mp4Size: String
)