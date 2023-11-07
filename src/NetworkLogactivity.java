import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.Request;
import org.openqa.selenium.devtools.v119.network.model.Response;

public class NetworkLogactivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		//log File
		devTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		
		
		
//		Map<String,Object> m=new HashMap<String,Object>();
//		m.put("maxTotalBufferSize", null);
//		m.put("maxResourceBufferSize", null);
//		m.put("maxPostDataSize", null);
//		
//		driver.executeCdpCommand("Network.enable", m);
		
		
		devTools.addListener(Network.requestWillBeSent(), request->
				
				{
				
					
					Request req=request.getRequest();
					System.out.println(req.getUrl());
					System.out.println(req.getHeaders());
				});
		
		
//		
		devTools.addListener(Network.responseReceived(), response->
		{
			Response res=response.getResponse();
			
			
			if(res.getStatus().toString().startsWith("4"))
			{
				System.out.println(res.getUrl());
				System.out.println(res.getStatus());
				System.out.println(res.getHeaders());
			}
			
		});
	
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
	}

}
