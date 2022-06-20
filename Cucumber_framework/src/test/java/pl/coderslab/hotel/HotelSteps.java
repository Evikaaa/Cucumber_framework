package pl.coderslab.hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class HotelSteps {

    private WebDriver driver;

    @Given("I'm on hotel main page")
    public void openHotelMainPage() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        // driver.manage().window().maximize();
        // Przejdź do Google
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("I sign in")
    public void iSignIn() {
        driver.findElement(By.className("user_login")).click();
    }

    @And("I enter unique email address on authentication page")
    public void iEnterUniqueEmailAddressOnAuthenticationPage() {
        String uniqueEmail = "art" + System.currentTimeMillis() + "@random.com";
        driver.findElement(By.className("account_input")).sendKeys(uniqueEmail);
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @And("^I enter name (.+) surname (.+) and password (.+)$")
    public void iEnterNameSurnameAndPassword(String name, String surname, String passwd) {
        driver.findElement(By.id("customer_firstname")).sendKeys(name);
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);
        driver.findElement(By.id("passwd")).sendKeys(passwd);
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("I can see success message with text {string}")
    public void iCanSeeSuccessMessageWithText(String message) {
        String alertMessage = driver.findElement(By.className("alert-success")).getText();
        assertEquals(message, alertMessage);
    }

    @And("close hotel browser")
    public void closeHotelBrowser() {
        driver.quit();
    }
}