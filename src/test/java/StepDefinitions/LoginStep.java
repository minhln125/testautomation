package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.By;


import io.cucumber.java.en.*;

public class start {	
	public void Setup() throws MalformedURLException {	
	     ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless","--no-sandbox","--disable-gpu");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(desiredCapabilities);
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(new URL("http://52.221.229.64:4444/"), options);
	}
}
public class LoginStep {
	@Given("on login page")
	public void on_login_page() {
		 driver.navigate().to("https://skhcn.erp.meu-solutions.com/");
	}

	@When("Enter user name and password")
	public void enter_user_name_and_password() {
	    System.out.println("enter user name and password");
	    driver.findElement(By.xpath("//meu-inventory-login//div[1]/input")).sendKeys("minhtrieu@meu-solutions.com");
	    driver.findElement(By.xpath("//meu-inventory-login//div[2]/input")).sendKeys("minhln1234");
	}

	@And("press login page")
	public void press_login_page() {
	  System.out.println("press login button");
	  driver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@Then("Navigate to homepage")
	public void navigate_to_homepage() {
	    System.out.println("navigate to homepage");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id=\"kt_header_brand\"]/div[1]/a/img[1]")).isDisplayed();
	    driver.close();
	    driver.quit();
	}
}
