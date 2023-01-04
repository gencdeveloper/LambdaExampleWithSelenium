package java8featureInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class LambdaBasicExamples2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.in/");



        Set<String> windowIds = driver.getWindowHandles();

//        for (String winid:windowIds) {
//
//            System.out.println(driver.switchTo().window(winid).getCurrentUrl());
//
//        }
        //lambda expression, we can use instead of forEach loop with single statement.
        windowIds.forEach(winid-> System.out.println(driver.switchTo().window(winid).getTitle()));

        driver.quit();

    }
}
