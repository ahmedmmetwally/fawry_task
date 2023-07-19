package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DeleteFirstItemPage {

    private WebDriver driver;

    public DeleteFirstItemPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id=\"itemContainerother\"]/tbody/tr[1]/td[3]/div[1]/div[1]/div[2]/button")
    WebElement deleteButton;

    @FindBy(className = "yes-noti")
    WebElement yesButton;

    public void submitDelete(){
        deleteButton.click();
    }

}

