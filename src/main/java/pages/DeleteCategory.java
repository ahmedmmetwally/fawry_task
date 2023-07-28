package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static pages.EditCategoryPage.textForDelete;


public class DeleteCategory {

    private WebDriver driver;
    int index = 0;

    public DeleteCategory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    private List<WebElement> categoryElementList;
    WebElement categoryElement;
    WebElement yesInDeleteRow;

    @FindBy(xpath = "//*[@id=\"itemContainerother_next\"]")
    WebElement nextButton;

//    WebDriverWait wait=new WebDriverWait(driver, 4)
//            .until(ExpectedConditions.visibilityOf(By.className("yes-noti")));

    boolean next = false;

    public void searchForDeleteItem() {
        for (int s = 1; s < categoryElementList.size() + 1; s++) {
            categoryElement = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + s + ") td:nth-child(1) h2"));
            String val = categoryElement.getText();
            //  if (val.equals("metwallyy")){
            if (val.equals(textForDelete)) {
                index = s;
                next = false;
            } else {index=0;
                next = true;}

        }
    }

    public void deleteItem() throws InterruptedException {
        Thread.sleep(6000);
        categoryElementList = this.driver.findElements(By.cssSelector("#itemContainerother > tbody tr"));
        System.out.println("the size of list delete is  :" + categoryElementList.size());
        searchForDeleteItem();
        if (next) {
            nextButton.click();
            Thread.sleep(1000);
            categoryElementList = this.driver.findElements(By.cssSelector("#itemContainerother > tbody tr"));
            System.out.println("the size of list delete 2 is  :" + categoryElementList.size());
            Thread.sleep(1000);
            searchForDeleteItem();
        }
        Thread.sleep(1000);
        WebElement deleteButtonElement = driver.findElement(By.cssSelector(" #itemContainerother > tbody tr:nth-child(" + index + ") td:nth-child(3) button"));
        deleteButtonElement.click();
        yesInDeleteRow = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + index + ") td:nth-child(3) input:nth-child(1)"));
       // deleteButtonElement.click();
        Thread.sleep(2000);
        yesInDeleteRow.click();
        System.out.println("delete done eeeeeeeeeeeee");
    }

}

