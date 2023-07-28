package testCases;

import data.JsonDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class LoginTest {
    WebDriver driver;
    private LoginPage loginPage;
    ChromeOptions chromeOptions;
    JsonDataReader jsonDataReader;

    LoginTest() {
        jsonDataReader = new JsonDataReader();
    }

    @BeforeTest(alwaysRun = true)
    public void Setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://transmission-dev.azurewebsites.net/login");
        driver.manage().window().maximize();

    }

    /////using jsonData
    @Test(priority = 1)
    public void Login() throws InterruptedException, IOException, ParseException {
        jsonDataReader.jsonReaderForLogin();
        loginPage = new LoginPage(driver);
        loginPage.Login(jsonDataReader.name, jsonDataReader.password);
    }

    // function to click on catalog button
    @Test(priority = 2)
    public void addCategory() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.addNewCatalog();
    }


    //using @DataProvider Annotation
    @DataProvider(name = "addCategory")
    public static Object[][] addCategoryNamesData() {
        return new Object[][]{{"ahmed", "متولى"}};
    }

    //addNewCategory
    @Test(priority = 3, dataProvider = "addCategory")
    public void addNewCategoryNames(String enName, String arName) throws InterruptedException {
        AddNewCategoryPage addNewCategoryPage = new AddNewCategoryPage(driver);
        addNewCategoryPage.addCategoryName(enName, arName);

    }

    //     using jsonData
    @Test(priority = 4)
    public void editCertinItem() throws InterruptedException, IOException, ParseException {
        jsonDataReader.jsonReaderForEditFirstItem();
        EditCategoryPage editCategoryPage = new EditCategoryPage(driver);
        editCategoryPage.editItem(jsonDataReader.englishNAme, jsonDataReader.arabicName);
    }

//    to delete item shoud be in the first page ..............
    @Test(priority = 5)
    public void deleteCat() throws InterruptedException {
        DeleteCategory deleteCategory = new DeleteCategory(driver);
        deleteCategory.deleteItem();
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
