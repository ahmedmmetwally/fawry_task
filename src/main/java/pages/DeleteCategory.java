package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static pages.AddNewCategoryPage.forDelete;


public class DeleteCategory {

    private WebDriver driver;
    int index=0;

    public DeleteCategory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    List<WebElement> categoryElementList;
    WebElement categoryElement;
    WebElement yesInDeleteRow;

//    WebDriverWait wait=new WebDriverWait(driver, 4)
//            .until(ExpectedConditions.visibilityOf(By.className("yes-noti")));

    public void deleteItem() throws InterruptedException {
        Thread.sleep(7000);
        categoryElementList = this.driver.findElements(By.cssSelector("#itemContainerother > tbody tr"));
        System.out.println("the size of list is  :" + categoryElementList.size());
        for (int s = 1; s < categoryElementList.size() + 1; s++) {
            categoryElement = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + s + ") td:nth-child(1) h2"));
            String val = categoryElement.getText();
//            if (val.equals("LGNairaTV")) {
            if (val.equals(forDelete)) {
                index = s;
                System.out.println("are the text is delete  :" + categoryElement.getText());
                System.out.println("the index of search it   is :" + index);
            }
            System.out.println("the value of index " + s + " is :" + val);

        }
        Thread.sleep(3000);
        WebElement deleteButtonElement = driver.findElement(By.cssSelector(" #itemContainerother > tbody tr:nth-child("+ index+") td:nth-child(3) button"));
        yesInDeleteRow= driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + index+ ") td:nth-child(3) input:nth-child(1)"));
        System.out.println("text should be delete  :" + deleteButtonElement.getText());
        System.out.println("text should be yes  :" + deleteButtonElement.getText());
        deleteButtonElement.click();
        Thread.sleep(3000);
        yesInDeleteRow.click();
        System.out.println("delete done eeeeeeeeeeeee");
    }

}

