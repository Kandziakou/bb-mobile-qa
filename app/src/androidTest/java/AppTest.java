import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import app.com.mobileassignment.views.MainActivity;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;


@RunWith(AllureAndroidJUnit4.class)
public class AppTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    @DisplayName("TEST: Searching of city. Positive case, city exist")
    public void searchCityPositiveCaseCity() {
        Steps steps = new Steps();
        String cityName = steps.selectRandomCity().getName();
        steps.searchCity(cityName);
        new Assertions().citiesAreDisplayed();
    }

    @Test
    @DisplayName("TEST: Searching of city by country. Positive case, city exist")
    public void searchCityPositiveCaseCountry() {
        Steps steps = new Steps();
        String contry = steps.selectRandomCity().getCountry();
        steps.searchCity(contry);
        new Assertions().citiesAreDisplayed();
    }

    @Test
    @DisplayName("TEST: Searching of city. Negative case, city doesn't exist")
    public void searchCityNegativeCase() {
        new Steps().searchCity("ABCDEFGH");
        new Assertions().citiesAreNotDisplayed();
    }

    @Test
    @DisplayName("TEST: List of city's is displayed when app is open")
    public void listOfCitiesIsDisplayed() {
        new Assertions().citiesAreDisplayed();
    }

    @Test
    @DisplayName("TEST: Show city on map")
    public void showCityFromSearchRequestOnMap() {
        Steps steps = new Steps();
        String cityName = steps.selectRandomCity().getName();
        steps.searchCity(cityName);
        steps.clickOnFirstCity();
        new Assertions().citiesAreDisplayed();
    }

    @Test
    @DisplayName("TEST: Show city on map")
    public void showCityOnMap() {
        new Steps().clickOnFirstCity();
        new Assertions().citiesAreDisplayed();
    }
}