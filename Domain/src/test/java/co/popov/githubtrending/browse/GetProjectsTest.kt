package co.popov.githubtrending.browse

import co.popov.domain.executor.PostExecutionThread
import co.popov.domain.browse.GetProjects
import co.popov.domain.model.Project
import co.popov.domain.repository.ProjectsRepository
import co.popov.githubtrending.test.ProjectDataFactory
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetProjectsTest {

    private lateinit var getProjects: GetProjects
    @Mock lateinit var projectsRepository: ProjectsRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getProjects = GetProjects(projectsRepository, postExecutionThread)
    }

    @Test
    fun getProjectsCompletes() {
        stubProjectsRepositoryGetProjects(
                Observable.just(ProjectDataFactory.makeProjectList(2)))
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsCallsRepository() {
        stubProjectsRepositoryGetProjects(
                Observable.just(ProjectDataFactory.makeProjectList(2)))
        getProjects.buildUseCaseObservable().test()
        verify(projectsRepository).getProjects()
    }

    @Test
    fun getProjectsReturnsData() {
        val projects = ProjectDataFactory.makeProjectList(2)
        stubProjectsRepositoryGetProjects(Observable.just(projects))
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertValue(projects)
    }

    private fun stubProjectsRepositoryGetProjects(observable: Observable<List<Project>>) {
        whenever(projectsRepository.getProjects())
                .thenReturn(observable)
    }

}