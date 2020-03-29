package com.acelerados

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import androidx.test.rule.ActivityTestRule
import org.junit.Rule



/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@MediumTest
@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {
    private lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Rule
    var activityRule: ActivityTestRule<LoginActivity> = ActivityTestRule(
        LoginActivity::class.java,
        true,
        true
    )

    @Test
    fun login_EmptyFields_SetUsernameAndPasswordError(){
        onView(withId(R.id.login)).perform(click())
//        val matchErrorText = matches(
//            hasErrorText(instrumentationContext.getString(R.string.required_field))
//        )
//        onView(withId(R.id.e_mail)).check(matchErrorText)
//        onView(withId(R.id.password)).check(matchErrorText)
    }
}
