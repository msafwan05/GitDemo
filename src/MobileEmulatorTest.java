import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.emulation.Emulation;
import org.openqa.selenium.devtools.v85.emulation.model.ScreenOrientation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();

		//send command to CDP methods-> CDP method will invoke ang get acces to chrome
		
		
		
		//done using selenium
//		//devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.<Number> empty(), 
//				Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
//				Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
//				Optional.<Object> empty(), Optional. <Object>empty()));
//		
		
		//done using driver
		Map deviceMetrics = new HashMap()
        {{
            put("width", 600);
            put("height", 1000);
            put("mobile", true);
            put("deviceScaleFactor", 50);
        }};
		
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		
		
	}

}
