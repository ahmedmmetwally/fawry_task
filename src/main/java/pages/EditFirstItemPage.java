package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EditFirstItemPage {
   private WebDriver driver;
    JavascriptExecutor js;

   public EditFirstItemPage(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);
       js=(JavascriptExecutor) driver;

   }
   @FindBy(xpath = "//*[@id=\"itemContainerother\"]/tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/a")
    WebElement editButton;

   @FindBy(xpath = "//*[@id=\"name_enedit63738230185795a04404292a\"]")
   WebElement editEnglishTextForm;

    @FindBy(xpath = "//*[@id=\"name_aredit63738230185795a04404292a\"]")
    WebElement editArabicTextForm;

    @FindBy(xpath = "//*[@id=\"edit-category\"]/div/input")
    WebElement editDoneButton;

    public void editItem(String english,String arabic) throws InterruptedException {
        Thread.sleep(3000);
        editButton.click();
        Thread.sleep(1000);
        editEnglishTextForm.clear();
        editEnglishTextForm.sendKeys(english);
        System.out.println("edit English Name is success"+arabic);
        Thread.sleep(1000);
        editArabicTextForm.clear();
      //  editArabicTextForm.sendKeys(arabic);
        //js.executeScript("document.getElementById('name_aredit6373822e185795a044042912').value='احمد متولى '");
       js.executeScript("arguments[0].value='تيست'", editArabicTextForm);
       // js.executeScript("arguments[0].setAttribute('value','"+ arabic +"')",editArabicTextForm);
        System.out.println("edit arabic Name is success");
        Thread.sleep(1000);
        editDoneButton.click();

    }
}
