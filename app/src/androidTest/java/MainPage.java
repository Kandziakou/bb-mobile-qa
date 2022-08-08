import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import app.com.mobileassignment.R;
public class MainPage {
    private final Matchers matchers = new Matchers();
    private final ViewInteraction search = onView(withId(R.id.search));
    private final DataInteraction city = onData(matchers.first(withId(R.id.cityName))).inAdapterView(withId(R.id.cityName));
    private final ViewInteraction firstCity = onView(matchers.first(withId(R.id.cityName)));
    private final ViewInteraction cities = onView(withId(R.id.cityName));

    public DataInteraction getCity() {
        return city;
    }

    public ViewInteraction getSearch() {
        return search;
    }

    public ViewInteraction getFirstCity() {
        return firstCity;
    }

    public ViewInteraction getCities() {
        return cities;
    }
}
