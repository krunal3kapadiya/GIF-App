package app.krunal3kapadiya.giphyapp.main

import app.krunal3kapadiya.giphyapp.di.ActivityScoped
import dagger.Binds
import dagger.Module

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

@Module
abstract class MainModule {
    @ActivityScoped
    @Binds
    abstract fun mainPresenter(presenter: MainPresenter): MainContract.Presenter
}
