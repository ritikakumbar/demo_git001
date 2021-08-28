package com.stackoverflow.testrig;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class StackEx {
public  WebDriver driver;

@BeforeSuite
public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	     driver=new ChromeDriver();
	     driver.get("https://stackoverflow.com/");
	     driver.manage().window().maximize();
}

@Test(priority=1)
public void countMaxQuestionsFromTag() {
   	String[] str; 
    int value=0,largenumber = 0;
    driver.findElement(By.xpath("/html/body/div[4]/div/button[1]")).click();
	driver.findElement(By.xpath("//*[@href='#']")).click();
	driver.findElement(By.linkText("Questions")).click();
	driver.findElement(By.linkText("Tags")).click();
	driver.findElement(By.linkText("New")).click();
	String actualText=driver.findElement(By.tagName("h1")).getText();
	String expextedText="Tags";
	Assert.assertEquals(actualText, expextedText);
	List<WebElement> listofque=driver.findElements(By.xpath("//div[contains(text(),'question') and @class='flex--item']"));
	for(WebElement ele:listofque)
	{
		String text=ele.getText();
		System.out.println(text);//
		str=text.split("\\s+");
	    value=Integer.parseInt(str[0]);
	    System.out.println(value);
		if(value>=largenumber)  
		{
			largenumber=value;
		}
	}
	
	String tagName=driver.findElement(By.xpath("//div[contains(text(),'"+largenumber+" question')]//preceding::a[1]")).getText();
	System.out.println("****************************************************");
	System.out.println("Number of tags on the first page :"+listofque.size());
	System.out.println("Count of highest questions on Tag:"+largenumber);
	System.out.println("Tag Name which is having highest question:"+tagName);
	System.out.println("****************************************************");
}

@AfterSuite
public void closeBrowser() {
	driver.close();
		}
}
