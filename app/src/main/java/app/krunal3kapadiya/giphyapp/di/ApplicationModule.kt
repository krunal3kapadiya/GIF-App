package app.krunal3kapadiya.giphyapp.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

@Module
abstract class ApplicationModule {
    //expose Application as an injectable context
    @Binds
    internal abstract fun bindContext(application: Application): Context
}
