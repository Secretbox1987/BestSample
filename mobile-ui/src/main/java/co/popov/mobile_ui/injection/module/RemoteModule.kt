package co.popov.mobile_ui.injection.module

import co.popov.data.repository.ProjectsRemote
import co.popov.mobile_ui.BuildConfig
import co.popov.remote.ProjectsRemoteImpl
import co.popov.remote.service.GithubTrendingService
import co.popov.remote.service.GithubTrendingServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideGithubService(): GithubTrendingService {
            return GithubTrendingServiceFactory.makeGithubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote
}