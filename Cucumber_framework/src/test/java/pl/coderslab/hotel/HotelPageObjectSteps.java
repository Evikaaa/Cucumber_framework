package pl.coderslab.hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.hotel.pageobject.*;

import java.time.Duration;

public class HotelPageObjectSteps {
    private WebDriver driver;
    private MyAddressesPage myAddressesPage;
    private String lastName;
    private String firstName;
    private String country;

    @Given("I'm on main page")
    public void openHotelMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("I go to login page")
    public void iGoToLoginPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.signIn();
    }

    @And("I login using {string} and {string}")
    public void iLoginUsingEmailAndPasswd(String login, String passwd) {
        AuthPage authPage = new AuthPage(driver);
        authPage.loginAs(login, passwd);
    }

    @And("I go to my addresses page")
    public void iGoToMyAddressesPage() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToMyAddresses();
    }

    @When("I add new address")
    public void iAddNewAddress() {
        myAddressesPage.addNewAddress();
    }

    @And("I enter new address {string}, {string}, {string}, {string}, {string}")
    public void iEnterNewAddress(String alias, String address, String postalCode, String city, String phoneNumber) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.enterNewAddressData(alias, address, postalCode, city, phoneNumber);
        firstName = newAddressPage.getFirstName();
        lastName = newAddressPage.getLastName();
        country = newAddressPage.getCountry();
        newAddressPage.saveAddress();
    }

    @Then("I can see new address")
    public void iCanSeeNewAddress() {
        Assert.assertTrue(myAddressesPage.addressIsVisible());
    }

    @Then("I can see there is no addresses")
    public void iCanSeeThereIsNoAddresses() {
        myAddressesPage = new MyAddressesPage(driver);
        Assert.assertFalse(myAddressesPage.addressIsVisible());
    }

    @And("I remove the address")
    public void iRemoveTheAddress() {
        myAddressesPage.removeAddresses();
    }

    @And("I can see that address was removed")
    public void iCanSeeThatAddressWasRemoved() {
        Assert.assertFalse(myAddressesPage.addressIsVisible());
    }

    @And("I verify created address {string}, {string}, {string}, {string}, {string}")
    public void iVerifyCreatedAddress(String alias, String address, String postalCode, String city, String phoneNumber) {
        String actualAddress = myAddressesPage.getFirstAddressAsText();
        String nameSurname = firstName + " " + lastName;
        String expectedAddress = String.join("\n", alias.toUpperCase(), nameSurname, address,
                postalCode + " " + city, country, phoneNumber);
        Assert.assertEquals(expectedAddress, actualAddress);
    }
}


