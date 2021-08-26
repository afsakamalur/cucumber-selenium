package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MyStepdefs {

    public WebDriver driver;
//    public OpenVolksBank openVolksBank;

    @Given("User Launch Chrome Browser")
    public void userLaunchChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
//        openVolksBank = new OpenVolksBank(driver);
    }

    @When("User opens URL {string}")
    public void userOpensURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))).click();

    }

    @And("User enters Volksbank in the search textbox")
    public void userEntersVolksbankInTheSearchTextbox() {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(" de Volksbank");
        List<WebElement> webElement = driver.findElements(By.name("btnK"));
        webElement.get(1).click();
    }

    @Then("the first search result is the Volksbank home page")
    public void theFirstSearchResultIsTheVolksbankHomePage() {
        driver.findElement(By.xpath("/html/body/div[7]/div/div[8]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a")).click();
        driver.close();
    }
}
