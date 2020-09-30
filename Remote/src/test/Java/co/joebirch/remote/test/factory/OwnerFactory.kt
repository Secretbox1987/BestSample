package co.popov.remote.test.factory

import co.popov.remote.model.OwnerModel

object OwnerFactory {

    fun makeOwnerModel(): OwnerModel {
        return OwnerModel(DataFactory.randomUuid(), DataFactory.randomUuid())
    }

}