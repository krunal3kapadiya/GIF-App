package app.krunal3kapadiya.giphyapp

/**
 * @author krunal kapadiya
 * @link https://krunal3kapadiya.app
 * @date 14,April,2019
 */

public interface BasePresenter<T> {
    fun takeView(view: T)

    fun dropView()
}