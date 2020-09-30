package co.popov.data.test.factory

import co.popov.data.model.ProjectEntity
import co.popov.domain.model.Project

object ProjectFactory {

    fun makeProjectEntity(): ProjectEntity {
        return ProjectEntity(DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomBoolean())
    }

    fun makeProject(): Project {
        return Project(DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomBoolean())
    }

}