import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import app.com.mobileassignment.R;
import io.qameta.allure.kotlin.Step;

public class Assertions {
    @Step("TEST: List of cities is displayed")
    public void citiesAreDisplayed()
    {
        onView(new Matchers().first(withId(R.id.cityName))).check(matches(isDisplayed()));
    }

    @Step("TEST: List of cities is displayed")
    public void citiesAreNotDisplayed()
    {
        onView(new Matchers().first(withId(R.id.cityName))).check(doesNotExist());
    }
}
