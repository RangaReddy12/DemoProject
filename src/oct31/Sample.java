package oct31;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		List<WebElement> alllinks =driver.findElements(By.tagName(""));

	}

}
