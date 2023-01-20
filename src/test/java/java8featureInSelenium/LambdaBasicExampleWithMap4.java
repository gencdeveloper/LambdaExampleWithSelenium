package java8featureInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LambdaBasicExampleWithMap4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        //all product list
        List<WebElement> prodTitle = driver.findElements(By.xpath("//h2[@class='product-title']"));

        //all product price list
        List<WebElement> prodtPrices = driver.findElements(By.xpath("//div[@class='prices']"));

        // i want to add 2 collection into one hashMap
        Map<String,Double> products_map = new HashMap<String,Double>();

        for ( int i=0; i<prodTitle.size(); i++)
        {
            String title = prodTitle.get(i).getText();
            Double price = Double.parseDouble(prodtPrices.get(i).getText());

            products_map.put(title,price);
        }

//        //Print map data using for..each loop
//        for(Map.Entry<String,Double>entry: products_map.entrySet()){
//            System.out.println(entry.getKey() + "    " + entry.getValue());
//        }


        //Print hashmap data using lambda exp...
        products_map.forEach((t,p)-> System.out.println(t+"  ||  "+p));

        /**Explanation comment for myself */
        //print product details whose prioce is >800
        //By using the enterySet() method, we can see our key and value datas in our HashMap object.

       // products_map.entrySet().stream().filter(e->e.getValue()>800) ---> which data bigger than 8000
        // .forEach(v-> System.out.println(v)); --> save to forEach and return it with lambda expression


        products_map.entrySet().stream().filter(e->e.getValue()>800).forEach(v-> System.out.println(v));

    }
}
