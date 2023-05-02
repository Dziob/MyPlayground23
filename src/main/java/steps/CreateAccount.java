package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LogInPage;

public class CreateAccount {

    public static WebDriver driver;

    public String url = "https://mystore-testlab.coderslab.pl/index.php";

    @Given("The user is on the Home page of mystore")
    public void setUp (){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("The user clicks on the sign in button")
    public void toSingIn(){
        HomePage homePage = new HomePage(driver);
        homePage.signIn();
    }

    @And("From the login page user chooses a create new account option")
    public void toCreateAccount(){
        LogInPage logInPage = new LogInPage(driver);
        logInPage.goToCreateAccount();
    }

    @And("The user filling a registration form and confirms creating an account")
    public void fillForm(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.fillForm();
        createAccountPage.sendForm();
    }
    @Then("The user can confirm the creation of the account by confirming the availability of the logout option")
    public void confirmAccount(){
        HomePage homePage = new HomePage(driver);
        //Assert.assertTrue(homePage.accountConfirm(), "Account created");
    }

    @And("The user signs out")
    public void logOut(){
        HomePage homePage = new HomePage(driver);
        homePage.logOut();
        homePage.logOutConfirm();
        //Assert.assertTrue(homePage.logOutConfirm(), "User successfully logged out ");
    }

    @And("User close the page")
    public void tearDown(){
        HomePage homePage = new HomePage(driver);
        homePage.quit(driver);
    }


}
