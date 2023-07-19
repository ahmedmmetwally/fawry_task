package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest {
    WebDriver driver;
    private HomePage homePage;

    @BeforeTest(alwaysRun = true)
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://transmission-dev.azurewebsites.net/login");
        driver.manage().window().maximize();
    }
//    @Test
//    public void Login() throws InterruptedException {
//        homePage=new HomePage(driver);
//        homePage.addNewCatalog(ca);
//    }

}
