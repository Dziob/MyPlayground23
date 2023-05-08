package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoppingCart;

public class AddToCart {

    public static WebDriver driver;

    public String url = "https://mystore-testlab.coderslab.pl/index.php";


    @Given ("The user is on the Home page of mystore.com")
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When ("From 'Popular Products' user chooses a 'Hummingbird Printed T-Shirt'")
    public void chooseProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.chooseTshirt();
    }

    @And ("Checking for a discount and chooses the 'L' size and the color black")
    public void productDetails(){
        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.checkDiscount(), "SAVE 20%");
        productPage.chooseSize();
        productPage.chooseColor();
    }

    @And("User adds one product to the cart")
    public void addToCart(){
        ProductPage productPage = new ProductPage(driver);
        productPage.toCart(driver);
    }

    @And("User confirms the action by using the 'Proceed to checkout button")
    public void proceedToCheckOut(){
        ProductPage productPage = new ProductPage(driver);
        productPage.toCheckout(driver);
    }

    @Then("User can see the product with the correct size, color, and price in the cart")
    public void cartCheck(){
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        Assert.assertEquals(shoppingCart.color(), "Black");
        Assert.assertEquals(shoppingCart.price(), "€19.12");
        Assert.assertEquals(shoppingCart.qty(driver), 1);
        Assert.assertEquals(shoppingCart.size(), "L");
    }

    @And("User deletes the product from the cart")
    public void deleteItemFromCart(){
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.delete();
        Assert.assertEquals(shoppingCart.confirmDelete(driver), "There are no more items in your cart");
    }

    @And("User closes the page")
    public void quit(){
        HomePage homePage = new HomePage(driver);
        homePage.quit(driver);
    }

}