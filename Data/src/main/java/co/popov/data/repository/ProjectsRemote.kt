package co.popov.data.repository

import co.popov.data.model.ProjectEntity
import io.reactivex.Flowable

interface ProjectsRemote {

    fun getProjects(): Flowable<List<ProjectEntity>>

}