package co.popov.mobile_ui.injection.module

import android.app.Application
import co.popov.cache.ProjectsCacheImpl
import co.popov.cache.db.ProjectsDatabase
import co.popov.data.repository.ProjectsCache
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CacheModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application): ProjectsDatabase {
            return ProjectsDatabase.getInstance(application)
        }
    }

    @Binds
    abstract fun bindProjectsCache(projectsCache: ProjectsCacheImpl): ProjectsCache
}