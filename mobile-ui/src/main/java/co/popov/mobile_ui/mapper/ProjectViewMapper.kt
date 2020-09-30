package co.popov.mobile_ui.mapper

import co.popov.mobile_ui.model.Project
import co.popov.presentation.model.ProjectView
import javax.inject.Inject

class ProjectViewMapper @Inject constructor(): ViewMapper<ProjectView, Project> {

    override fun mapToView(presentation: ProjectView): Project {
        return Project(presentation.id, presentation.name,
                presentation.fullName, presentation.starCount,
                presentation.dateCreated, presentation.ownerName,
                presentation.ownerAvatar, presentation.isBookmarked)
    }

}