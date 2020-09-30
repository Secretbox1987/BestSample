package co.popov.cache.test.factory

import co.popov.cache.model.Config

object ConfigDataFactory {

    fun makeCachedConfig(): Config {
        return Config(DataFactory.randomInt(), DataFactory.randomLong())
    }

}