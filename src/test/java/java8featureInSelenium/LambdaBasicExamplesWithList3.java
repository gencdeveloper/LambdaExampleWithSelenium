package java8featureInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaBasicExamplesWithList3 {

//    1) Display books in sorted order(A-Z) using DropDown
//    2) Capture all the products in to a list (Original list)
//    3) Sort products ( using stream & lamda)then capture in to another list (Sorted list)
//    4) Compare Original list with Sorted list

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://demowebshop.tricentis.com/");

        //Books page link
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']")).click();

        //select value from dropdown
        Select sortbydrp = new Select(driver.findElement(By.id("products-orderby")));
        sortbydrp.selectByVisibleText("Name: A to Z");

        List<WebElement> product_items=driver.findElements(By.xpath("//h2[@class='product-title']"));
        //use Lambda expression
        List <String> beforeSort = product_items.stream().map(item->item.getText()).collect(Collectors.toList());

        List<String> afterSort = product_items.stream().map(item->item.getText()).sorted().collect(Collectors.toList());

        if(beforeSort.equals(afterSort))
        {
            System.out.println("Products are sorted");
        }   else {
            System.out.println("products are not sorted");
        }

    }

}
