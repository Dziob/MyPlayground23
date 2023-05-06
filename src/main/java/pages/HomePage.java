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

    @FindBy(xpath = "//a[@class='logout hidden-sm-down']")
    WebElement signOutBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/section/div/div[1]/article/div/div[1]")
    WebElement tShirt;

    public void signIn() {
        signInBtn.click();
    }
    public boolean accountConfirm() {
        return customerIcon.isDisplayed();
    }

    public void logOut(){
        signOutBtn.click();
    }

    public boolean logOutConfirm(){
        return signInBtn.isDisplayed();
    }

    public void quit(WebDriver driver){
        driver.quit();
    }

    public void chooseTshirt(){
        tShirt.click();
    }


}
