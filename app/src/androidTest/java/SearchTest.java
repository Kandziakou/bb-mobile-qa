import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import io.qameta.allure.kotlin.junit4.AllureParametrizedRunner;
import io.qameta.allure.kotlin.junit4.DisplayName;


@RunWith(AllureParametrizedRunner.class)
public class SearchTest extends BaseTest{
    private final String by;
    private final String testData;
    private final boolean expected;

    public SearchTest(CharSequence by, CharSequence testData, boolean expected) {
        this.by = (String) by;
        this.testData = (String) testData;
        this.expected = expected;
    }

    @Parameters
    public static List<Object[]> searchRequest() {
        return Arrays.asList(new Object[][] {
                { "city", "Berlin", true },
                { "city", " Berlin", true },
                { "city", "Berlin ", true },
                { "city", "berlin", true },
                { "city", "BERLIN", true },
                { "any", "Berli", true },
                { "country", "BR", true },
                { "country", "br", true },
                { "any", "ABCDEFGHIJKL", false },
                { "any", "12313425", false}
        });
    }

    @Test
    @DisplayName("TEST: Searching of city.")
    public void searchCity() {
        steps.searchCity(testData);
        assertions.areCitiesDisplayed(expected);
        if (expected){
            assertions.allElementsIncludeThatValue(by, testData);
        }
    }
}
