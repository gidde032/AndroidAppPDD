package com.example.androidapppdd

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StartButtonTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        disableAnimations()

        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
        enableAnimations()
    }

    @Test
    fun testStartButton() {
        Espresso.onView(ViewMatchers.withId(R.id.startButton))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.startButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tyranitarImage))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.welcomeText))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    private fun disableAnimations() {
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            "settings put global window_animation_scale 0"
        )
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            "settings put global transition_animation_scale 0"
        )
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            "settings put global animator_duration_scale 0"
        )
    }

    private fun enableAnimations() {
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            "settings put global window_animation_scale 1"
        )
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            "settings put global transition_animation_scale 1"
        )
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            "settings put global animator_duration_scale 1"
        )
    }
}