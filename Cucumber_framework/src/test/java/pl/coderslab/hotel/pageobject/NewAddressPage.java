package pl.coderslab.hotel.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "postcode")
    private WebElement postalCodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    @FindBy(id = "alias")
    private WebElement aliasInput;

    @FindBy(id = "submitAddress")
    private WebElement saveBtn;

    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "id_country")
    private WebElement countrySelect;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterNewAddressData(String alias, String address, String postalCode, String city, String phoneNumber) {
        addressInput.clear();
        addressInput.sendKeys(address);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        cityInput.clear();
        cityInput.sendKeys(city);

        mobilePhoneInput.clear();
        mobilePhoneInput.sendKeys(phoneNumber);

        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void saveAddress() {
        saveBtn.click();
    }

    public String getFirstName() {
        return firstNameInput.getAttribute("value");
    }

    public String getLastName() {
        return lastNameInput.getAttribute("value");
    }

    public String getCountry() {
        Select select = new Select(countrySelect);
        return select.getFirstSelectedOption().getText();
    }
}
