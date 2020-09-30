package co.popov.remote.test.factory

import co.popov.remote.model.ProjectModel

object ProjectFactory {

    fun makeProjectModel(): ProjectModel {
        return ProjectModel(DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomInt(), DataFactory.randomUuid(),
                OwnerFactory.makeOwnerModel())
    }

}