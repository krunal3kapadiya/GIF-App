package app.krunal3kapadiya.giphyapp.main

import android.content.Context
import app.krunal3kapadiya.giphyapp.BuildConfig
import app.krunal3kapadiya.giphyapp.di.ActivityScoped
import app.krunal3kapadiya.giphyapp.netwwork.GiphyApi
import app.krunal3kapadiya.giphyapp.netwwork.NetworkService
import app.krunal3kapadiya.giphyapp.netwwork.responses.Data
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

@ActivityScoped
class MainPresenter @Inject constructor() : MainContract.Presenter {

    var mMainView: MainContract.View? = null
    var datalist: ArrayList<Data?>? = ArrayList()

    override fun takeView(view: MainContract.View) {
        mMainView = view
    }

    override fun apiCallTrendingData(context: Context) {
        val giphyApi: GiphyApi = NetworkService.provideNetworkApi()
        giphyApi.getTrendingPublicApi(BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    mMainView?.setLoadingIndicator(false)
                    for (data in it.data!!) {
                        datalist?.add(data)
                    }
                    datalist?.let { it1 -> mMainView?.loadData(it1) }
                    mMainView?.setLoadingIndicator(false)
                },
                {
                    mMainView?.setLoadingIndicator(false)
                }
            )
    }

    override fun dropView() {
        mMainView = null
    }
}