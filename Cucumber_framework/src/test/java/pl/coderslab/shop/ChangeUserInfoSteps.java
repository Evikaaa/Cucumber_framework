package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.shop.pageobject.LoginPage;
import pl.coderslab.shop.pageobject.UserInfoPage;
import java.time.Duration;

public class ChangeUserInfoSteps {

    UserInfoPage userInfoPage;
    WebDriver driver;

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLoggedInToCodersLabShop() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
    }

    @When("^User goes to UserInformationPage$")
    public void heGoesToUserInformationPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=identity");
        userInfoPage = new UserInfoPage(driver);
    }

    @And("^User changes his birthday to \"([^\"]*)\"$")
    public void userChangesHisBirthdayTo(String date) {
        userInfoPage.setBirthdate(date);
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
        userInfoPage.signInForNewsletter();
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        userInfoPage.submitUserInfo();
    }

    @Then("^User sees \"([^\"]*)\"$")
    //będzie cudzysłów, dalej w środku dowolne znaki, które nie są cudzysłowem, i dalej na końcu znowu cudzysłów
    public void userSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
    }
}
