package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EditFirstItemPage {
   private WebDriver driver;

   public EditFirstItemPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);

   }
   @FindBy(xpath = "//*[@id=\"itemContainerother\"]/tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/a")
    WebElement editButton;

   @FindBy(xpath = "//*[@id=\"name_enedit6373822e185795a044042912\"]")
   WebElement editEnglishTextForm;

    @FindBy(xpath = "//*[@id=\"name_aredit6373822e185795a044042912\"]")
    WebElement editArabicTextForm;

    @FindBy(xpath = "//*[@id=\"edit-category\"]/div/input")
    WebElement editDoneButton;

    public void editItem(String english,String arabic) throws InterruptedException {
        Thread.sleep(9000);
        editButton.click();
        editEnglishTextForm.clear();
        Thread.sleep(1000);
        editEnglishTextForm.sendKeys(english);
        System.out.println("edit English Name is success");
        Thread.sleep(1000);
        editArabicTextForm.clear();
        editArabicTextForm.sendKeys(arabic);
        System.out.println("edit English Name is success");
        Thread.sleep(1000);
        editButton.click();

    }
}
