package app.krunal3kapadiya.giphyapp.main

import app.krunal3kapadiya.giphyapp.BasePresenter
import app.krunal3kapadiya.giphyapp.BaseView

/**
 * This specifies the contract between the view and the presenter.
 */
interface MainContract {
    //TODO set multiple actions here
    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter<View>
}
