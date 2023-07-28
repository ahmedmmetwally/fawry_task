package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCategoryPage {
    private WebDriver driver;
    private JavascriptExecutor js;

    public AddNewCategoryPage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"tab2\"]/div[2]/div[1]/div[1]/a")
    private WebElement addNewCategoryButton;


    @FindBy(id = "add_name_en")
    private WebElement addEnglishName;

    @FindBy(id = "add_name_ar")
    private WebElement addArabicName;

    @FindBy(className = "submit-branch")
    private WebElement donButton;
    public static String editName;

    public void addCategoryName(String english, String ArbName) throws InterruptedException {
        editName = english;
        Thread.sleep(5000);
        addNewCategoryButton.click();
        addEnglishName.sendKeys(english);
        Thread.sleep(1000);
        js.executeScript("arguments[0].setAttribute('value','" + ArbName + "')", addArabicName);
        Thread.sleep(1000);
        donButton.click();
        System.out.println("add new item done");
    }
}
