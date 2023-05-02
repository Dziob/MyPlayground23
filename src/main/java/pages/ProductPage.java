package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage (WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//span[@class='discount discount-percentage']")
    WebElement discount;

    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    WebElement addToCartBtn;

}
