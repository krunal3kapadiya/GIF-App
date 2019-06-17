package app.krunal3kapadiya.giphyapp.di

import app.krunal3kapadiya.giphyapp.main.MainActivity
import app.krunal3kapadiya.giphyapp.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}
