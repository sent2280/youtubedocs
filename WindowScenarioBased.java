package realtimeintquestpart2;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowScenarioBased {

	public static void main(String[] args) throws InterruptedException {
		
		String url = "https://www.amazon.com/";
		System.setProperty("webdriver.chrome.driver", "F:\\YoutubeVideoMaker\\SupportingDocs\\driver\\chromedriver.exe");

    	ChromeDriver driver = new ChromeDriver();
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    	driver.get(url);
    	
    	Actions action = new Actions(driver);
    	
    	driver.findElementById("twotabsearchtextbox").clear();
    	driver.findElementById("twotabsearchtextbox").sendKeys("samsung");
    	driver.findElementById("nav-search-submit-button").click();
    	List<WebElement> productLinkList = driver.findElementsByXPath("//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']");  	 
   
    	System.out.println("Total Elements " + productLinkList.size());
    	for(int counter = 0; counter < 3; counter++){
    		action.keyDown(Keys.CONTROL).
    		click(productLinkList.get(counter)).
    		keyUp(Keys.CONTROL).
    		build().perform();
    			
    	}
    	Thread.sleep(5 * 000);
    	
    	Set<String> windowIds = driver.getWindowHandles();
    	System.out.println("total windows = " + windowIds.size());
    	Iterator<String> itr = windowIds.iterator();
    	String parentWindow = driver.getWindowHandle();
    	
    	while(itr.hasNext()){
    		String currentWindow = itr.next();
    		
    		if(!currentWindow.equals(parentWindow)){
    			driver.switchTo().window(currentWindow);
        		System.out.println("productTitle = " + driver.findElementById("productTitle").getText());
        		driver.close();
    		}	
    	}
	}

}
