package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCategoryPage {
   private WebDriver driver;
   private JavascriptExecutor js;

   public AddNewCategoryPage(WebDriver driver){
        this.driver=driver;
        js=(JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"tab2\"]/div[2]/div[1]/div[1]/a")
    private WebElement addNewCategoryButton;


    @FindBy(id = "add_name_en")
   private WebElement addEnglishName;

    @FindBy(id = "add_name_ar")
    private WebElement addArabicName;

    @FindBy(className = "submit-branch")
    private WebElement donButton;
   // public static String test;
    public void addCategoryName(String english,String ArbName) throws InterruptedException {
        Thread.sleep(7000);
       //  test=english;
        addNewCategoryButton.click();
        System.out.println("AddNewCategory button is pressed");
        addEnglishName.sendKeys(english);
        System.out.println("Add English Name is success");
        Thread.sleep(2000);
       // js.executeScript("arguments[0].value='تمام'", addArabicName);
        js.executeScript("arguments[0].setAttribute('value','"+ ArbName +"')",addArabicName);
        System.out.println("Add arabic Name is success");
        Thread.sleep(3000);
        donButton.click();
        System.out.println("add new item done");
    }
}
