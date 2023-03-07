package HW1

import android.view.View
import androidx.constraintlayout.core.widgets.Helper
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.R
import org.hamcrest.Matcher
import org.junit.Assert
import org.junit.Test

@LargeTest
class ExampleInstrumentedTest {

    @Test
    fun pageActions(){
        nextBtn.tap()
        secondPgValidation.isViewDisplayed()
        backBtn.isViewDisplayed()

    }

    companion object{
        val nextBtn: Matcher<View> by lazy { ViewMatchers.withId(R.id.button_next_activity) }
        val secondPgValidation: Matcher<View> by lazy {ViewMatchers.withId(R.id.activity_secondary_title)}
        val backBtn: Matcher<View> by lazy { ViewMatchers.withId(R.id.button_back) }
    }
}

