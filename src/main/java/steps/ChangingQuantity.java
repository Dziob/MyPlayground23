package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.ProductPage;
import pages.SweaterPage;

public class ChangingQuantity {

    public static WebDriver driver;

    public String url = "https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s";

    @Given("The user is on the product page - 'Hummingbird Printed Sweater'")
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("Checking for a discount and chooses the 'M' size")
    public void productDetails(){
        SweaterPage sweaterPage = new SweaterPage(driver);
        Assert.assertEquals(sweaterPage.sweaterDiscountCheck(), "SAVE 20%");
        sweaterPage.chooseSweaterSize();

    }

}
