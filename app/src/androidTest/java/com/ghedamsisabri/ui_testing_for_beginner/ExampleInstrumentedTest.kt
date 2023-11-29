package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.assertIfViewIsNotDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.assertIsNotViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.assertIsViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.getText
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkSecondPage() {
        NextBtn.tap()
        secondPageActivity.isViewDisplayed()

        isTextOnScreen("SecondaryActivity")
        Assert.assertEquals("SecondaryActivity", secondPageActivity.getText(5))
    }

    @Test
    fun validateMainAndSecondaryScreens() {
        MainPageActivity.assertIsViewDisplayed()
        NextBtn.assertIsViewDisplayed()

        NextBtn.tap()

        secondPageActivity.assertIsViewDisplayed()
        Assert.assertEquals("SecondaryActivity", secondPageActivity.getText())

        BackBtn.assertIsViewDisplayed()
        Assert.assertEquals("Back", BackBtn.getText())
    }

    @Test
    fun validateNavigationInAPP() {
        MainPageActivity.assertIsViewDisplayed()
        NextBtn.assertIsViewDisplayed()

        NextBtn.tap()
        BackBtn.tap()

//        secondPageActivity.assertIsNotViewDisplayed()
        MainPageActivity.assertIsViewDisplayed()
        NextBtn.assertIsViewDisplayed()
    }

    companion object{
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val secondPageActivity: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
        val MainPageActivity: Matcher<View> by lazy { withId(R.id.activity_main_title) }
        val BackBtn: Matcher<View> by lazy { withId(R.id.button_back) }
    }
}