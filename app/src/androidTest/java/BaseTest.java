import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;

import app.com.mobileassignment.views.MainActivity;
import io.qameta.allure.android.rules.LogcatRule;
import io.qameta.allure.android.rules.ScreenshotRule;

public class BaseTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.END, "ss_end");


    @Rule
    public LogcatRule logcatRule = new LogcatRule();

    Steps steps = new Steps();
    Assertions assertions = new Assertions();
}
