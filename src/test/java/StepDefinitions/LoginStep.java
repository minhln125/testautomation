package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.*;

public class LoginStep {
	WebDriver driver = null;
	@Given("on login page")
	public void on_login_page() {
		String projectPath = System.getProperty("user.dir");
	    System.out.println("project path is:"+ projectPath);
	    System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/driver/chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//	    driver.manage().window().maximize();
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
	}

	@Then("Navigate to homepage")
	public void navigate_to_homepage() {
	    System.out.println("navigate to homepage");
	    driver.findElement(By.xpath("//*[@id=\"kt_header_brand\"]/div[1]/a/img[1]")).isDisplayed();
	    driver.close();
	    driver.quit();
	}
}
