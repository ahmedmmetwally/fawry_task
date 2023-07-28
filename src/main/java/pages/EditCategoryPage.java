package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static pages.AddNewCategoryPage.editName;

public class EditCategoryPage {
    WebDriver driver;
    int index = 0;
    private JavascriptExecutor js;

    public EditCategoryPage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

   private List<WebElement> categoryElementList;
    WebElement categoryElement;
    WebElement editEnglish;
    WebElement editArabic;
    WebElement doneButton;
    @FindBy(xpath = "//*[@id=\"itemContainerother_next\"]")
    WebElement nextButton;
    public  static String textForDelete;
    boolean next=false;
    public void searchForDeleteItem(){
        for (int s = 1; s < categoryElementList.size() + 1; s++) {
            categoryElement = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + s + ") td:nth-child(1) h2"));
            String val = categoryElement.getText();
            if (val.equals(editName)){
                index = s;
                next=false;
            }
            else next=true;

        }
    }
    public void editItem(String english, String arabic) throws InterruptedException {
        textForDelete=english;
        Thread.sleep(5000);
        categoryElementList = this.driver.findElements(By.cssSelector("#itemContainerother > tbody tr"));
        System.out.println("the size of list in edit is  :" + categoryElementList.size());
        searchForDeleteItem();
        if(next){
            nextButton.click();
            Thread.sleep(3000);
            categoryElementList = this.driver.findElements(By.cssSelector("#itemContainerother > tbody tr"));
            System.out.println("the size of list in edit 2 is  :" + categoryElementList.size());
            //Thread.sleep(1000);
            searchForDeleteItem();
        }
        Thread.sleep(1000);
        WebElement editButtonElement = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + index + ") td:nth-child(3) a"));
        editButtonElement.click();
        Thread.sleep(2000);
        editEnglish = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + index + ") td:nth-child(3) form li:nth-child(1) input"));
        editArabic = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + index + ") td:nth-child(3) form li:nth-child(2) input"));
        doneButton = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + index + ") td:nth-child(3)  form >div>input"));
        Thread.sleep(1000);
        editEnglish.clear();
        editEnglish.sendKeys(english);
        Thread.sleep(1000);
        editArabic.clear();
        js.executeScript("arguments[0].value='" + arabic + "'", editArabic);
        Thread.sleep(1000);
        doneButton.click();
    }


}
