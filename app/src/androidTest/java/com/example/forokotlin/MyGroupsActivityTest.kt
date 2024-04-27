package com.example.forokotlin


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MyGroupsActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MyGroupsActivity::class.java)

    @Test
    fun myGroupsActivityTest() {

        val overflowMenuButton = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton.perform(click())

        val materialTextView = onView(
            allOf(
                withId(androidx.transition.R.id.title), withText("Configuración"),
                childAtPosition(
                    childAtPosition(
                        withId(androidx.appcompat.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())

        val appCompatEditText14 = onView(
            allOf(
                withId(R.id.txtAgeUpdate), withText("25"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatEditText14.perform(replaceText("26"))

        val appCompatEditText15 = onView(
            allOf(
                withId(R.id.txtAgeUpdate), withText("26"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatEditText15.perform(closeSoftKeyboard())

        val appCompatEditText16 = onView(
            allOf(
                withId(R.id.txtAgeUpdate), withText("26"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatEditText16.perform(pressImeActionButton())

        val appCompatEditText17 = onView(
            allOf(
                withId(R.id.txtEmailUpdate), withText("espresso@espresso.com"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText17.perform(pressImeActionButton())

        val materialButton5 = onView(
            allOf(
                withId(R.id.button), withText("Actualizar"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        materialButton5.perform(click())

        val overflowMenuButton2 = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton2.perform(click())

        val materialTextView2 = onView(
            allOf(
                withId(androidx.transition.R.id.title), withText("Añadir grupo"),
                childAtPosition(
                    childAtPosition(
                        withId(androidx.appcompat.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView2.perform(click())

        val appCompatEditText18 = onView(
            allOf(
                withId(R.id.groupName),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText18.perform(replaceText("Nuevo "), closeSoftKeyboard())

        val appCompatEditText19 = onView(
            allOf(
                withId(R.id.groupDescription),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText19.perform(replaceText("Nuevo"), closeSoftKeyboard())

        val materialButton7 = onView(
            allOf(
                withId(R.id.btnAddGroup), withText("Añadir grupo"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        materialButton7.perform(click())

        val overflowMenuButton3 = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton3.perform(click())

        val materialTextView3 = onView(
            allOf(
                withId(androidx.transition.R.id.title), withText("Todos los grupos"),
                childAtPosition(
                    childAtPosition(
                        withId(androidx.appcompat.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView3.perform(click())

        val overflowMenuButton4 = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton4.perform(click())

        val materialTextView4 = onView(
            allOf(
                withId(androidx.transition.R.id.title), withText("Mis grupos"),
                childAtPosition(
                    childAtPosition(
                        withId(androidx.appcompat.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView4.perform(click())

        val overflowMenuButton5 = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton5.perform(click())

        val materialTextView5 = onView(
            allOf(
                withId(androidx.transition.R.id.title), withText("Cerrar sesión"),
                childAtPosition(
                    childAtPosition(
                        withId(androidx.appcompat.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView5.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
