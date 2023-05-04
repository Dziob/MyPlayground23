package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    public ProductPage (WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//span[@class='discount discount-percentage']")
    WebElement discount;

    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(xpath = "//input[@title='Black']")
    WebElement colorBlack;

    @FindBy(xpath = "//input[@title='White']")
    WebElement colorWhite;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[1]/a[@class='btn btn-primary']")
    WebElement proceedBtn;

    public String checkDiscount(){
        return discount.getText();
    }

    public void chooseSize(){
        Select chooseSize = new Select(size);
        chooseSize.selectByVisibleText("L");
    }

    public void chooseColor(){
        colorBlack.click();
    }

    public void toCart(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeSelected(colorBlack));
        addToCartBtn.click();

    }

    public void toCheckout(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(proceedBtn));
        proceedBtn.click();
    }



}
