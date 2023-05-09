package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



}
