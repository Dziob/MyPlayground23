package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public LogInPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "no-account")
    WebElement createAccountBtn;


    public void goToCreateAccount(){
        createAccountBtn.click();
    }

}
