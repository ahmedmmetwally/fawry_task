package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/ul/li[1]/a")
    private WebElement catalogButton;

    /*   @FindBy(css = "#itemContainerother > tbody td:nth-child(1) h2")
       private WebElement cateorName;

       //int count =driver.findElements(By.cssSelector("#itemContainerother > tbody tr")).size();
       //List<WebElement> list =this.driver.findElements(By.cssSelector("#itemContainerother > tbody tr"));


       //   @FindBy(xpath = "//*[@id=\"tab2\"]/div[2]/div[1]/div[1]/a")
   //   private WebElement addNewCategoryButton;

   //    @FindBy(xpath= "//*[@id=\"itemContainerother\"]/tbody/tr[1]/td[1]/div/div[2]/a")
   //    WebElement findName;
   */
    public void addNewCatalog() throws InterruptedException {
        Thread.sleep(2000);
        catalogButton.click();
    }
}