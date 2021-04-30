package com.tazkiyatech.app1

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    fun launch_activity() {
        // When.
        activityScenario = launch(MainActivity::class.java)

        // Then.
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
    }

    @Test
    fun pause_and_resume_activity() {
        // Given.
        activityScenario = launch(MainActivity::class.java)

        // When.
        activityScenario.moveToState(Lifecycle.State.CREATED)
        activityScenario.moveToState(Lifecycle.State.RESUMED)

        // Then.
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
    }

    @Test
    fun recreate_activity() {
        // Given.
        activityScenario = launch(MainActivity::class.java)

        // When.
        activityScenario.recreate()

        // Then.
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
    }
}