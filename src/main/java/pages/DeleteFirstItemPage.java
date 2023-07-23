package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteFirstItemPage {

    private WebDriver driver;

    public DeleteFirstItemPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id=\"itemContainerother\"]/tbody/tr[1]/td[3]/div[1]/div[1]/div[2]/button")
    WebElement deleteButton;

    @FindBy(className = "no-noti")
    WebElement yesButton;
//    WebDriverWait wait=new WebDriverWait(driver, 4)
//            .until(ExpectedConditions.visibilityOf(By.className("yes-noti")));
    public void deleteItem() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("before click delete button eeeeeeeeeeeee");
        deleteButton.click();
        Thread.sleep(5000);
        yesButton.click();
        System.out.println("delete done eeeeeeeeeeeee");
    }

}

