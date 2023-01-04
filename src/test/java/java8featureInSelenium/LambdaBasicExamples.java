package java8featureInSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LambdaBasicExamples {

	//EXAMPLE
	//	/1) Find Number of Links in Page
	//
	//  2) Print Link Texts from all the links
	//
	//  3) Check how many links does not have href attribute(broken links)

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");

		//	/1) Find Number of Links in Page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links present on the page " + links.size());


		//  2) Print Link Texts from all the links
			//		for (WebElement link:links)
			//		{
			//			System.out.println(link.getText());
			//		}

			//with lambda expression
			links.forEach(link-> System.out.println(link.getText()));


		//  3) Check how many links does not have href attribute(broken links)
		//Processing elements using stream ->Filter
		long workingLinks = links.stream().filter(link->link.getAttribute("href")!=null).count();
		System.out.println("working list are:" + workingLinks);

		driver.close();

	}
}
