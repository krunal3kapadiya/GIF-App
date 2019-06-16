package app.krunal3kapadiya.giphyapp.viewVideo

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import app.krunal3kapadiya.giphyapp.R
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import kotlinx.android.synthetic.main.fragment_video_view.*
import kotlinx.android.synthetic.main.fragment_video_view.view.*


/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

class VideoViewFragment : DialogFragment() {

    companion object {
        fun newInstance(name: String, videoUrl: String): VideoViewFragment {
            val fragment = VideoViewFragment()
            val bundle = Bundle()
            bundle.putString("url", videoUrl)
            bundle.putString("name", name)
            fragment.arguments = bundle
            return fragment
        }
    }

    lateinit var player: SimpleExoPlayer
    lateinit var videoUrl: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_video_view, container, false)
        videoUrl = arguments?.getString("url").toString()
        val name = arguments?.getString("name").toString()
        view.text_title.text = name
        view.img_up.setOnClickListener {
            Toast.makeText(context, "Coming soon", Toast.LENGTH_LONG).show()
        }

        view.img_down.setOnClickListener {
            Toast.makeText(context, "Coming soon", Toast.LENGTH_LONG).show()
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setWindowAnimations(
            R.style.dialog_animation_fade
        )
        initializePlayer(videoUrl = videoUrl)
    }

    private fun initializePlayer(videoUrl: String) {
        player = ExoPlayerFactory.newSimpleInstance(
            context,
            DefaultRenderersFactory(context),
            DefaultTrackSelector(), DefaultLoadControl()
        )
        player_view.useController = false
        player_view.player = player
        val uri = Uri.parse(videoUrl)
        val mediaSource = buildMediaSource(uri)
        player.prepare(mediaSource, true, false)
        player.playWhenReady = true
        player.repeatMode = Player.REPEAT_MODE_ALL
    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        return ExtractorMediaSource.Factory(
            DefaultHttpDataSourceFactory("exoplayer-codelab")
        ).createMediaSource(uri)
    }
}