package pl.coderslab.hotel.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class MyAddressesPage {

    private WebDriver driver;

    @FindBy(css = "a[title='Add an address']")
    private WebElement newAddressBtn;

    @FindBy(css = ".bloc_adresses .address")
    private List<WebElement> addresses;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress() {
        newAddressBtn.click();
    }

    public boolean addressIsVisible() {
        return addresses.size() > 0;
    }

    public void removeAddresses() {
        for (WebElement address : addresses) {
            address.findElement(By.cssSelector("a[title=Delete]")).click();
            driver.switchTo().alert().accept();
        }
    }

    public String getFirstAddressAsText() {
        WebElement address = addresses.get(0);
        String[] lines = address.getText().split("\n");
        lines = Arrays.copyOf(lines, lines.length - 2);
        return String.join("\n", lines);
    }
}
