package springtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringTest {
    private static final By FIRST_LINK = By.xpath("//cite[1]");

    public WebDriver driver;

    public static void main(String[] args) {
        SpringApplication.run(SpringTest.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        openVolksBank();
        return String.format("Hello %s!", name);
    }

    public void openVolksBank() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))).click();
        driver.findElement(By.name("q")).sendKeys(" de Volksbank");
        driver.findElements(By.name("btnK")).get(1).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(FIRST_LINK)).click();
        driver.close();
    }
}
