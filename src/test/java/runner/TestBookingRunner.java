package runner;


import app.TestBase;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author Edward
 * @since 04/04/2022
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/booking.feature",
        glue = {"stepsDefs"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber2.json"}
)
public class TestBookingRunner extends TestBase {
}
