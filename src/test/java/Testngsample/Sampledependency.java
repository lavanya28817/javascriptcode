package Testngsample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sampledependency {
	WebDriver d;
	@Test
	public void stUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users/HOME/Downloads/SOFTWARES/chromedriver.exe");
		   d=new ChromeDriver();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.get("https://www.facebook.com/");
	
		String back=d.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img")).getCssValue("color");
		System.out.println(back);
		JavascriptExecutor js=(JavascriptExecutor)d;
		String ele="document.getElementById('pass').style.border='2px solid purple'";
		js.executeScript(ele);
		Thread.sleep(3000);
		WebElement mail=d.findElement(By.id("email"));
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red')",mail);

		Thread.sleep(3000);
		WebElement logbtn=d.findElement(By.partialLinkText("Create New Accou"));
				
		flash(logbtn, d);
		Thread.sleep(3000);
	}
		public static void flash(WebElement element, WebDriver driver) {
	        
	        JavascriptExecutor js = ((JavascriptExecutor)driver);
	        String bgcolor = element.getCssValue("backgroundColor");
	        for (int i = 0; i < 100; i++) {
	            changeColor("rgb(255, 0, 200)", element, driver); 
	            changeColor(bgcolor, element, driver); 
	            
	        }
	    }
	        public static void changeColor(String color, WebElement element, WebDriver driver) {
	            JavascriptExecutor js = ((JavascriptExecutor)driver);
	            js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
	            try {
	                Thread.sleep(20);
	          
	            }catch (InterruptedException e) {

	            }
	
		
		
	}
	@Test
	public void tearDown()
	{
		d.close();
	}
}


