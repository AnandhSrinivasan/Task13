package file_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class Launch_Browser_Perform {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		//driver = new EdgeDriver(); 
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com");
		WebElement searchbox =  driver.findElement(By.name("q"));
		searchbox.sendKeys("Samsung");
		//searchbox.click();`
		searchbox.submit();
		String Title = driver.getTitle();
		System.out.println("Web Page Title is: " + Title);
		driver.close();
	}
}
