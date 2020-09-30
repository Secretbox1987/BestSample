package co.popov.mobile_ui.injection.module

import co.popov.data.ProjectsDataRepository
import co.popov.domain.repository.ProjectsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository): ProjectsRepository
}