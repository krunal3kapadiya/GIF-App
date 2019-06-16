package app.krunal3kapadiya.giphyapp.main

import android.content.Context
import app.krunal3kapadiya.giphyapp.BasePresenter
import app.krunal3kapadiya.giphyapp.BaseView
import app.krunal3kapadiya.giphyapp.netwwork.responses.Data

/**
 * This specifies the contract between the view and the presenter.
 */
interface MainContract {
    interface View : BaseView<Presenter> {
        fun setLoadingIndicator(active: Boolean)
        fun loadData(giphyDataList: ArrayList<Data?>)
    }

    interface Presenter : BasePresenter<View> {
        fun apiCallTrendingData(context: Context)
    }
}
