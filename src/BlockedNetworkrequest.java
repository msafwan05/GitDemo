import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockedNetworkrequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
			
			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
			
			//takes the execution time
			long starttime=System.currentTimeMillis();
			
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());

		long endtime=System.currentTimeMillis();
		
		System.out.println(endtime-starttime);
	}

}
