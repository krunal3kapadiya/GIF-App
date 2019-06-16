package app.krunal3kapadiya.giphyapp.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.krunal3kapadiya.giphyapp.BuildConfig
import app.krunal3kapadiya.giphyapp.di.ActivityScoped
import app.krunal3kapadiya.giphyapp.main.adapter.GiphyListAdapter
import app.krunal3kapadiya.giphyapp.netwwork.GiphyApi
import app.krunal3kapadiya.giphyapp.netwwork.NetworkService
import app.krunal3kapadiya.giphyapp.netwwork.responses.Data
import app.krunal3kapadiya.giphyapp.util.Common
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

@ActivityScoped
class MainActivity : DaggerAppCompatActivity(), MainContract.View {

    lateinit var datalist: ArrayList<Data?>
    lateinit var adapter: GiphyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(app.krunal3kapadiya.giphyapp.R.layout.activity_main)

        datalist = ArrayList()
        main_recycler_view.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        //API Call completed
        adapter = GiphyListAdapter(datalist)
        main_recycler_view.adapter = adapter
        makeApiCall(datalist, adapter)
        swipe_up.setOnRefreshListener {
            datalist.clear()
            makeApiCall(datalist, adapter)
        }
    }

    fun makeApiCall(datalist: ArrayList<Data?>, adapter: GiphyListAdapter) {

        if (Common.isNetworkAvailable(this)) {
            progress_circular.visibility = View.VISIBLE
            val giphyApi: GiphyApi = NetworkService.provideNetworkApi()

            giphyApi.getTrendingPublicApi(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        progress_circular.visibility = View.GONE
                        for (data in it.data!!) {
                            datalist.add(data)
                        }
                        adapter.notifyDataSetChanged()
                        setSwipeUpRefreshing()
                    },
                    {
                        setSwipeUpRefreshing()
                        progress_circular.visibility = View.GONE
                    }
                )
        } else {
            displayInternetNotAvailable()
        }
    }

    private fun displayInternetNotAvailable() {
        internet_not_available.visibility = View.VISIBLE
    }

    fun setSwipeUpRefreshing() {
        if (swipe_up.isRefreshing) {
            swipe_up.isRefreshing = false
        }
    }
}
