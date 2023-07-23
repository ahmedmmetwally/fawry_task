package testCases;

import data.JsonDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
    // function to login
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
    public static Object[][] addCategoryNamesData(){
        return new Object[][]{{"ali"}};
    }
    //addNewCategory
    @Test(priority = 3,dataProvider = "addCategory")
    public void addNewCategoryNames(String name) throws InterruptedException{
        AddNewCategoryPage addNewCategoryPage=new AddNewCategoryPage(driver);
        addNewCategoryPage.addCategoryName(name);

    }
    // using jsonData
   // funtion to editFirstItem
    @Test(priority = 4)
    public void editFirstItem() throws InterruptedException, IOException, ParseException {
        jsonDataReader.jsonReaderForEditFirstItem();
        EditFirstItemPage editFirstItemPage = new EditFirstItemPage(driver);
        editFirstItemPage.editItem(jsonDataReader.englishNAme, jsonDataReader.arabicName.toString());
        System.out.println(jsonDataReader.englishNAme);
    }

    @Test(priority = 3)
    public void deleteFirstItem() throws InterruptedException {
        DeleteFirstItemPage deleteFirstItemPage = new DeleteFirstItemPage(driver);
        deleteFirstItemPage.deleteItem();
    }
}
