package co.popov.mobile_ui.test.factory

import co.popov.presentation.model.ProjectView

object ProjectFactory {

    fun makeProjectView(): ProjectView {
        return ProjectView(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomBoolean())
    }

}