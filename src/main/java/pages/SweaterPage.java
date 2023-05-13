package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SweaterPage {
    public SweaterPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='discount discount-percentage']")
    WebElement sweaterDiscount;

    @FindBy(id = "group_1")
    WebElement sweaterSize;

    @FindBy(id = "quantity_wanted")
    WebElement sweaterQty;

    @FindBy(className = "add")
    WebElement addToCart;

    @FindBy(xpath = "//div[1]/a[@class='btn btn-primary']")
    WebElement proceedBtn;

    public String sweaterDiscountCheck(){
        return sweaterDiscount.getText();
    }

    public void chooseSweaterSize(){
        Select size = new Select(sweaterSize);
        size.selectByVisibleText("M");
    }

    public void chooseQty(){
        sweaterQty.click();
        sweaterQty.sendKeys(Keys.CONTROL + "a");
        sweaterQty.sendKeys(String.valueOf(5));

    }

    public void AddSweaterToCart(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.textToBe((By) sweaterQty, "5"));
        addToCart.click();
        wait.until(ExpectedConditions.visibilityOf(proceedBtn));
        proceedBtn.click();
    }




}
