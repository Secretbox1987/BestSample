package co.popov.mobile_ui.injection

import android.app.Application
import co.popov.cache.db.ProjectsDatabase
import co.popov.data.repository.ProjectsCache
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides

@Module
object TestCacheModule {

    @Provides
    @JvmStatic
    fun provideDatabase(application: Application): ProjectsDatabase {
        return ProjectsDatabase.getInstance(application)
    }

    @Provides
    @JvmStatic
    fun provideProjectsCache(): ProjectsCache {
        return mock()
    }

}