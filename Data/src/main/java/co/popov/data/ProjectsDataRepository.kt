package co.popov.data

import co.popov.data.mapper.ProjectMapper
import co.popov.data.repository.ProjectsCache
import co.popov.data.store.ProjectsDataStoreFactory
import co.popov.data.store.ProjectsRemoteDataStore
import co.popov.domain.model.Project
import co.popov.domain.repository.ProjectsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class ProjectsDataRepository @Inject constructor(
        private val mapper: ProjectMapper,
        private val cache: ProjectsCache,
        private val factory: ProjectsRemoteDataStore,
        private val factory2: ProjectsDataStoreFactory)
    : ProjectsRepository {

    override fun getProjects(): Observable<List<Project>> {
        return factory2.getRemoteDataStore().getProjects().toObservable().map {
            it.map {
                mapper.mapFromEntity(it)
            }
        }
//        return Observable.zip(cache.areProjectsCached().toObservable(),
//                cache.isProjectsCacheExpired().toObservable(),
//                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { areCached, isExpired ->
//                    Pair(areCached, isExpired)
//                })
//                .flatMap {
//                    factory.getDataStore(it.first, it.second).getProjects().toObservable()
//                            .distinctUntilChanged()
//                }
//                .flatMap { projects ->
//                    factory.getCacheDataStore()
//                            .saveProjects(projects)
//                            .andThen(Observable.just(projects))
//                }
//                .map {
//                    it.map {
//                        mapper.mapFromEntity(it)
//                    }
//                }
    }

    override fun bookmarkProject(projectId: String): Completable {
        return factory2.getCacheDataStore().setProjectAsBookmarked(projectId)
    }

    override fun unbookmarkProject(projectId: String): Completable {
        return factory2.getCacheDataStore().setProjectAsNotBookmarked(projectId)
    }

    override fun getBookmarkedProjects(): Observable<List<Project>> {
        return factory2.getCacheDataStore().getBookmarkedProjects().toObservable()
                .map { it.map { mapper.mapFromEntity(it) } }
    }

}