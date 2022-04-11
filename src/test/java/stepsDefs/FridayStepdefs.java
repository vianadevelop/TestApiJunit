package stepsDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * @author Edward
 * @since 03/30/2022
 */
class IsItFriday {
    static String isItFriday(String today) {
       return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}

public class FridayStepdefs {
    private String today;
    private String actualAnswer;

    @Given("today is Sunday")
    public void todayIsSunday() {
        today = "Sunday";
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String expectedAnswer) {
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("today is {string}")
    public void todayIs(String today) {
        this.today = today;
    }
}
