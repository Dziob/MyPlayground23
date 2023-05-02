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

    @FindBy(xpath = "//input[@name='customer_privacy']")
    WebElement customerDataPrivacyCheckbox;
    @FindBy(xpath = "//input[@name='psgdpr']")
    WebElement policyCheckbox;

    @FindBy(xpath = "//button[@class='btn btn-primary form-control-submit float-xs-right']")
    WebElement saveBtn;

    public void fillForm(){

        socialTitleMrs.click();
        firstName.sendKeys("Magdalena");
        lastName.sendKeys("Dziob");
        email.sendKeys("magda7@email.com");
        password.sendKeys("haslo");
        customerDataPrivacyCheckbox.click();
        policyCheckbox.click();

    }

    public void sendForm(){
        saveBtn.click();
    }

    public void quit(WebDriver driver){driver.quit();}

}
