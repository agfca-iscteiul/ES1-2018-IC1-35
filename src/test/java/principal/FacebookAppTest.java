package principal;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAppTest {

	private FacebookApp app = new FacebookApp();
	private WebDriver driver;
	
	public void setUpBeforeClass() throws InterruptedException{
		  driver=new ChromeDriver();
		  driver.get("http://www.facebook.com");
		  Thread.sleep(5000);
		  driver.findElement(By.id("email")).sendKeys("usares@outlook.pt");
		  driver.findElement(By.id("pass")).sendKeys("ESgrupo35");
		  driver.findElement(By.id("u_0_n")).click();
		  System.out.println("Login com Sucesso");
	}
	
	
	@Test
	public void testRunFacebook() {
	}

	@Test
	public void testGetList() {
	}
	
	public void tearDownAfterClass() {
		driver.close();
	}
}
