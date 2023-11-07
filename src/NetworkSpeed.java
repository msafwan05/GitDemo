import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//Network.emulateNetworkConditions
		devTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 20000, Optional.of(ConnectionType.ETHERNET)));
		
		//Network.loadingFailed 
devTools.addListener(Network.loadingFailed(), loadingFailed->
{
	System.out.println(loadingFailed.getErrorText());

	System.out.println(loadingFailed.getTimestamp());
});
		
		
		Long startTime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Long endTime=System.currentTimeMillis();
		System.out.println(startTime-endTime);
		//18316
		
	}

}
