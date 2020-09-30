package co.popov.mobile_ui.injection

import android.app.Application
import co.popov.domain.repository.ProjectsRepository
import co.popov.mobile_ui.injection.module.PresentationModule
import co.popov.mobile_ui.injection.module.UiModule
import co.popov.mobile_ui.test.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        TestApplicationModule::class,
        TestCacheModule::class,
        TestDataModule::class,
        PresentationModule::class,
        UiModule::class,
        TestRemoteModule::class))
interface TestApplicationComponent {

    fun projectsRepository(): ProjectsRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

    fun inject(application: TestApplication)

}