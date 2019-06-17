package app.krunal3kapadiya.giphyapp.viewVideo

import app.krunal3kapadiya.giphyapp.BasePresenter
import app.krunal3kapadiya.giphyapp.BaseView

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

interface ViewVideoContract {
    interface View : BaseView<Presenter> {
    }

    interface Presenter : BasePresenter<View> {
    }
}
