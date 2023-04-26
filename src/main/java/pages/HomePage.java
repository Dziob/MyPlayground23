package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".user-info")
    WebElement signInBtn;

    @FindBy(xpath = "//a[@class='logout hidden-sm-down']")
    WebElement customerIcon;


    public void signIn() {
        signInBtn.click();

    }
    public boolean accountConfirm() {
        return customerIcon.isDisplayed();
    }


}
