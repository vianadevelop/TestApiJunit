package stepsDefs;

import io.cucumber.java.*;
import io.restassured.RestAssured;
import org.jetbrains.annotations.NotNull;
import utils.PropertySource;
import utils.constants.KeyProperties;

public class StepDefinitions {
    // https://github.com/cucumber/cucumber-jvm/tree/main/java#hooks

    /**
     * Think twice before you use Before
     * Whatever happens in a Before hook is invisible to people who only read the features.
     * You should consider using a background as a more explicit alternative, especially if the setup should be readable by non-technical people.
     * Only use a Before hook for low-level logic such as starting a browser or deleting data from a database.
     */


    @BeforeAll
    public static void beforeAll() {
        PropertySource prop = new PropertySource();
        RestAssured.baseURI = prop.getProperty(KeyProperties.BASE_URI.getValue());
        RestAssured.port = Integer.parseInt(prop.getProperty(KeyProperties.PORT.getValue()));
        RestAssured.useRelaxedHTTPSValidation();
        System.out.println("HOOK: BEFORE ALL");
    }

    @AfterAll
    public static void afterAll() {
        RestAssured.reset();
        System.out.println("HOOK: AFTER ALL");
    }

    @Before("not @Friday")
    public void before(@NotNull Scenario scenario) {
        scenario.log("Runs before each scenarios *not* tagged with @Friday");
        System.out.println("BEFORE SCENARIO: " + scenario.getName() + " WITH STATUS: " + scenario.getStatus());
    }

    @After
    public void after(@NotNull Scenario scenario) {
        scenario.log("Runs after each scenarios");
        System.out.println("AFTER SCENARIO: " + scenario.getName() + " WITH STATUS: " + scenario.getStatus());
    }
}
