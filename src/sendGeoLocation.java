import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class sendGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		ChromeDriver driver=new ChromeDriver();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		
		//spain cordinates are 40,3
		
		Map<String, Object> coordinates= new HashMap<String,Object>();
		coordinates.put("latitude", 35);
		coordinates.put("longitude", 6);
		coordinates.put("accuracy", 1);
				
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("APjFqb")).sendKeys("Netflix",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		System.out.println(driver.findElement(By.cssSelector("h1.default-ltr-cache-jpuyb8")).getText());
		
	}

}
