package co.popov.remote

import co.popov.data.model.ProjectEntity
import co.popov.data.repository.ProjectsRemote
import co.popov.remote.mapper.ProjectsResponseModelMapper
import co.popov.remote.service.GithubTrendingService
import io.reactivex.Flowable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
        private val service: GithubTrendingService,
        private val mapper: ProjectsResponseModelMapper)
    : ProjectsRemote {

    override fun getProjects(): Flowable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
                .map {
                    it.items.map { mapper.mapFromModel(it) }
                }
    }
}