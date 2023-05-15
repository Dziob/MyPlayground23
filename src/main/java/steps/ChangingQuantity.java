package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoppingCart;
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
    @Then("Changing the quantity of the product to '5'")
    public void qtyInTheCart(){
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.qtyUp(driver);
    }

    @And("Proced to checkout")
    public void checkout(){
        SweaterPage sweaterPage = new SweaterPage(driver);
        sweaterPage.AddSweaterToCart(driver);
    }

    @And("Checking if quantity and size are correct")
    public void confirmProduct(){
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        Assert.assertEquals(shoppingCart.size(), "L");
        Assert.assertEquals(shoppingCart.qty(driver), 5);
    }

    @Then("Changing the quantity to '3'")
    public void changingQty(){
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.qtyChange();
    }

    @And("Checking if quantity is correct")
    public  void confirmQtyChange(){
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        Assert.assertEquals(shoppingCart.qty(driver), 3);
    }

    @And("Closing the page")
    public void quit(){
        HomePage homePage = new HomePage(driver);
        homePage.quit(driver);
    }

}
