import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import java.util.concurrent.ThreadLocalRandom;

import app.com.MyApp;
import app.com.mobileassignment.R;
import app.com.mobileassignment.model.City;
import app.com.mobileassignment.utils.JsonMapper;
import io.qameta.allure.kotlin.Step;

public class Steps {
    @Step("Type '{cityName} to search field'")
    public void searchCity(String cityName){
        onView(withId(R.id.search)).perform(typeText(cityName));
    }

    @Step("Select first city in list")
    public void clickOnFirstCity(){
        onData(new Matchers().first(withId(R.id.cityName))).perform(click());
    }

    @Step("Select random city from 'cities.json'")
    public City selectRandomCity(){
        int random = ThreadLocalRandom.current().nextInt(0, 209557);
        return (City) new JsonMapper().getCityListFromRawFile(MyApp.getAppContext(), random);
    }
}
