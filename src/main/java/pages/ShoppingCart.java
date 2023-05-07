package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCart {
    public ShoppingCart (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[3]/span[@class='value']")
    WebElement checkSize;

    @FindBy(xpath = "//div[4]/span[@class='value']")
    WebElement checkColor;

    @FindBy(xpath = "//span[@class='product-price']")
    WebElement checkPrice;

    @FindBy(xpath = "//div[@class='col-md-6 col-xs-6 qty']")
    WebElement checkQty;

    @FindBy(xpath = "//i[@class='material-icons float-xs-left']")
    WebElement delete;

    @FindBy(xpath = "//span[@class='no-items']")
    WebElement confirmDelete;

    public String size(){
        return checkSize.getText();
    }

    public String color(){
        return checkColor.getText();
    }

    public String price(){
        return checkPrice.getText();
    }

    public String qty(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5) );
        return checkQty.getAttribute("value");
    }

    public void delete(){
        delete.click();
    }

    public String confirmDelete(){
        return confirmDelete.getText();
    }



}
