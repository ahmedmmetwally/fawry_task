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
        Thread.sleep(4000);
        catalogButton.click();
        System.out.println("Catalog button is pressed");
/*
        Thread.sleep(9000);
        // int categoryCount =driver.findElements(By.cssSelector("#itemContainerother > tbody td:nth-child(1) h2")).size();
        // int deleteButtonCount =driver.findElements(By.cssSelector("#itemContainerother > tbody td:nth-child(3) button")).size();
        List<WebElement> categoryElementList = this.driver.findElements(By.cssSelector("#itemContainerother > tbody tr"));
        int size = categoryElementList.size();
//       var name = findName.getAttribute("href");
//       System.out.println("the size is :"+count);
        System.out.println("the size of list is  :" + categoryElementList.size());
//        for(WebElement i :list){
//            System.out.println(i.getTagName());
//        }
        int index=0;
        Thread.sleep(7000);
        for (int s = 1; s < categoryElementList.size() + 1; s++) {
            WebElement element = driver.findElement(By.cssSelector("#itemContainerother > tbody tr:nth-child(" + s + ") td:nth-child(1) h2"));
            String val = element.getText();
            if (val.equals("metwally ua")) {
                index = s;
                System.out.println("the index of search it   is :" + index);
            }
            System.out.println("the value of index " + s + " is :" + val);

            // System.out.println(element.getTagName()+"    "+s+"fdfdfd");

        }
       WebElement element = driver.findElement(By.cssSelector(" #itemContainerother > tbody tr:nth-child("+ index+") td:nth-child(3) button"));
        String ss= element.getText();
        System.out.println(ss+"   ssssssssssssss");

*/

        //Thread.sleep(7000);
//    addNewCategoryButton.click();

    }
}