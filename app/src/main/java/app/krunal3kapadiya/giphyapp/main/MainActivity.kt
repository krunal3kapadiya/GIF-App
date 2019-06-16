package app.krunal3kapadiya.giphyapp.main

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import app.krunal3kapadiya.giphyapp.di.ActivityScoped
import app.krunal3kapadiya.giphyapp.main.adapter.GiphyListAdapter
import app.krunal3kapadiya.giphyapp.netwwork.responses.Data
import app.krunal3kapadiya.giphyapp.util.Common
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScoped
class MainActivity : DaggerAppCompatActivity(), MainContract.View, SearchView.OnQueryTextListener {
    @Inject
    lateinit var mainPresenter: MainPresenter
    lateinit var adapter: GiphyListAdapter
    private var searchView: SearchView? = null

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(app.krunal3kapadiya.giphyapp.R.menu.main_menu, menu)
        val searchMenuItem = menu?.findItem(app.krunal3kapadiya.giphyapp.R.id.action_search)
        searchView = searchMenuItem?.actionView as SearchView
        searchView!!.setOnQueryTextListener(this)
        searchView!!.queryHint = "Search"
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        mainPresenter.searchQuery(query)
        searchView?.let { Common.hideKeyboard(this, it) }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    override fun onBackPressed() {
        if (!searchView?.isIconified!!) {
            searchView?.isIconified = true
            mainPresenter.apiCallTrendingData(this)
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.dropView()
    }
}
