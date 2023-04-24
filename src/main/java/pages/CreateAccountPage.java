package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    public CreateAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//label[@for='field-id_gender-1']")
    WebElement socialTitleMr;

    @FindBy(xpath = "//label[@for='field-id_gender-2']")
    WebElement socialTitleMrs;

    @FindBy(id = "field-firstname")
    WebElement firstName;

    @FindBy(id = "field-lastname")
    WebElement lastName;

    @FindBy(id = "field-email")
    WebElement email;

    @FindBy(id = "field-password")
    WebElement password;

    @FindBy(xpath = "//input[@name='psgdpr']")
    WebElement policyCheckbox;

    public void fillForm(){

        socialTitleMrs.click();
        firstName.sendKeys("Magdalena");
        lastName.sendKeys("Dziob");
        email.sendKeys("magda@email.com");
        password.sendKeys("haslo");
        policyCheckbox.click();
    }

    public void quit(WebDriver driver){driver.quit();}

}
