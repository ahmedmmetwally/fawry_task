package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

   public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/ul/li[1]/a")
    private WebElement  catalogButton;

//   @FindBy(xpath = "//*[@id=\"tab2\"]/div[2]/div[1]/div[1]/a")
//   private WebElement addNewCategoryButton;
//

  public void addNewCatalog() throws InterruptedException {
      Thread.sleep(2000);
    catalogButton.click();
    System.out.println("Catalog button is pressed");
//      Thread.sleep(7000);
//    addNewCategoryButton.click();
//      System.out.println("AddNewCategory button is pressed");
    }
}