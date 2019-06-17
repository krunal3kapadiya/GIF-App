package app.krunal3kapadiya.giphyapp.di

import android.app.Application
import app.krunal3kapadiya.giphyapp.GiphyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */


@Singleton
@Component(
    modules = [ActivityBindingModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class]
)
interface AppComponent : AndroidInjector<GiphyApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
