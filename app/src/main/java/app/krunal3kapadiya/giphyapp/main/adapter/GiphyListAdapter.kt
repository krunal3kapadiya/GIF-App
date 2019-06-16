package app.krunal3kapadiya.giphyapp.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.krunal3kapadiya.giphyapp.netwwork.responses.Data
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_item.view.*


/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

class GiphyListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    private var data = ArrayList<Data?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType === VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(parent.context)
                .inflate(app.krunal3kapadiya.giphyapp.R.layout.row_item, parent, false)
            ViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(app.krunal3kapadiya.giphyapp.R.layout.row_loading, parent, false)
            LoadingViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position] == null) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder)
            data[position]?.let { holder.bind(it) }
    }

    fun setData(giphyDataList: ArrayList<Data?>) {
        data.addAll(giphyDataList)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: Data) {
            itemView.row_text.text = data.title

            Glide.with(itemView.context)
                .load(data.images?.original?.webp)
                .centerCrop()
                .placeholder(app.krunal3kapadiya.giphyapp.R.drawable.ic_launcher_foreground)
                .into(itemView.row_image_view)
        }
    }

    class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //TODO add loading
    }
}