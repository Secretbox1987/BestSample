package co.popov.mobile_ui.injection.module

import co.popov.domain.executor.PostExecutionThread
import co.popov.mobile_ui.UiThread
import co.popov.mobile_ui.bookmarked.BookmarkedActivity
import co.popov.mobile_ui.browse.BrowseActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity(): BrowseActivity

    @ContributesAndroidInjector
    abstract fun contributesBookmarkedActivity(): BookmarkedActivity
}