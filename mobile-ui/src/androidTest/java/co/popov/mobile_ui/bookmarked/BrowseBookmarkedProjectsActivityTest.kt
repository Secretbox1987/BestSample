package co.popov.mobile_ui.bookmarked

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.popov.domain.model.Project
import co.popov.mobile_ui.R
import co.popov.mobile_ui.test.TestApplication
import co.popov.mobile_ui.test.factory.ProjectDataFactory
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BrowseBookmarkedProjectsActivityTest {

    @Rule @JvmField
    val activity = ActivityTestRule<BookmarkedActivity>(BookmarkedActivity::class.java, false,
            false)

    @Test
    fun activityLaunches() {
        stubProjectsRepositoryGetBookmarkedProjects(Observable.just(listOf(
                ProjectDataFactory.makeProject())))
        activity.launchActivity(null)
    }

    @Test
    fun bookmarkedProjectsDisplay() {
        val projects = listOf(ProjectDataFactory.makeProject(), ProjectDataFactory.makeProject(),
                ProjectDataFactory.makeProject(), ProjectDataFactory.makeProject())
        stubProjectsRepositoryGetBookmarkedProjects(Observable.just(projects))

        activity.launchActivity(null)

        projects.forEachIndexed { index, project ->
            onView(withId(R.id.recycler_projects))
                    .perform(RecyclerViewActions.scrollToPosition<BookmarkedAdapter.ViewHolder>(
                            index))

            onView(withId(R.id.recycler_projects))
                    .check(matches(hasDescendant(withText(project.fullName))))
        }
    }

    private fun stubProjectsRepositoryGetBookmarkedProjects(observable: Observable<List<Project>>) {
        whenever(TestApplication.appComponent().projectsRepository().getBookmarkedProjects())
                .thenReturn(observable)
    }

}