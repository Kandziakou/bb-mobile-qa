import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import androidx.test.espresso.action.ViewActions;

import io.qameta.allure.kotlin.Step;

public class Steps {
    MainPage mainPage = new MainPage();
    @Step("Search by '{by}'")
    public void searchCity(String by){
        mainPage.getSearch().perform(typeText(by));
    }

    @Step("Select first city in list")
    public void clickOnFirstCity(){
        mainPage.getFirstCity().perform(click());
    }

    @Step("Press BACK button")
    public void pressBack(){
        onView(isRoot()).perform(ViewActions.pressBack());
    }
}
