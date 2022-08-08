import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;


@RunWith(AllureAndroidJUnit4.class)
public class AppTest extends BaseTest{
    @Test
    @DisplayName("TEST: List of city's is displayed when app is open")
    public void listOfCitiesIsDisplayed() {
        assertions.areCitiesDisplayed(true);
    }

    @Test
    @DisplayName("TEST: Show city on map after search")
    public void showCityFromSearchRequestOnMap() {
        String cityName = "Berlin";
        steps.searchCity(cityName);
        steps.clickOnFirstCity();
        assertions.isMapOpen();
    }

    @Test
    @DisplayName("TEST: Show city from start menu on map")
    public void showCityOnMap() {
        steps.clickOnFirstCity();
        assertions.isMapOpen();
    }

    @Test
    @DisplayName("TEST: Show main page after return from map")
    public void returnFromMap(){
        steps.clickOnFirstCity();
        steps.pressBack();
        assertions.isMainPageOpen();
    }
}