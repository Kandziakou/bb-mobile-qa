import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;

import app.com.mobileassignment.R;
import io.qameta.allure.kotlin.Step;

public class Assertions {
    @Step("ASSERT: Is this {expected} that cities are displayed?")
    public void areCitiesDisplayed(boolean expected){
        if (expected) {
            onView(new Matchers().first(withId(R.id.cityName))).check(matches(isDisplayed()));
        }
        else {
            onView(new Matchers().first(withId(R.id.cityName))).check(doesNotExist());
        }
    }

    @Step("ASSERT: All list members include '{value}' in their description")
    public void allElementsIncludeThatValue(String by, String value){
        org.hamcrest.Matcher<String> matcher;
        if(by.equals("country")) {
            matcher = endsWith(value);
        }
        else if(by.equals("city")) {
            matcher = startsWith(value);
        }
        else {
            matcher = containsString(value);
        }
        onView(new Matchers().first(withId(R.id.cityName))).check(matches(withText(matcher)));
    }


    @Step("ASSERT: Map is open")
    public void isMapOpen(){
        onView(withId(R.id.search)).check(doesNotExist());
    }

    @Step("ASSERT: Main page is open")
    public void isMainPageOpen(){
        onView(withId(R.id.citiesList)).check(matches(isDisplayed()));
    }
}
