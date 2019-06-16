package app.krunal3kapadiya.giphyapp.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.krunal3kapadiya.giphyapp.di.ActivityScoped
import app.krunal3kapadiya.giphyapp.main.adapter.GiphyListAdapter
import app.krunal3kapadiya.giphyapp.netwwork.responses.Data
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScoped
class MainActivity : DaggerAppCompatActivity(), MainContract.View {

    @Inject
    lateinit var mainPresenter: MainPresenter
    lateinit var adapter: GiphyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(app.krunal3kapadiya.giphyapp.R.layout.activity_main)

        main_recycler_view.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        //API Call completed
        adapter = GiphyListAdapter()
        main_recycler_view.adapter = adapter

        mainPresenter.apiCallTrendingData(this)

        swipe_up.setOnRefreshListener {
            mainPresenter.apiCallTrendingData(this)
        }

        mainPresenter.takeView(this)
    }


    override fun setLoadingIndicator(active: Boolean) {
        progress_circular.visibility = if (active) View.VISIBLE else View.GONE
        main_recycler_view.visibility = if (active) View.GONE else View.VISIBLE
        swipe_up.isRefreshing = active
    }

    override fun loadData(giphyDataList: ArrayList<Data?>) {
        adapter.setData(giphyDataList)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.dropView()
    }
}
