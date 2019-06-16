package app.krunal3kapadiya.giphyapp.viewVideo

import app.krunal3kapadiya.giphyapp.di.ActivityScoped
import dagger.Binds
import dagger.Module

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

@Module
abstract class ViewVideoModule {
    @ActivityScoped
    @Binds
    abstract fun videVideoPresenter(viewVideoPresenter: ViewVideoPresenter): ViewVideoContract.Presenter
}
