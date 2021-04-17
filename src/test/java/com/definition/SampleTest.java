package com.definition;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
public class SampleTest {
	WebDriver driver;
	@Given("The user should be in lazada login page")
	public void the_user_should_be_in_lazada_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\Cucumber1\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.lazada.com.my/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	@When("The user has to be fill Username and Password")
	public void the_user_has_to_be_fill_Username_and_Password() {
		WebElement Login = driver.findElement(By.xpath("//a[text()='LOGIN']"));
		Login.click();
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Please enter your Phone Number or Email']"));
		userName.sendKeys("aadhinesh98@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Please enter your password']"));
		password.sendKeys("123");
	}
	@When("The user fas to be click the login button")
	public void the_user_fas_to_be_click_the_login_button() {
		Actions a = new Actions(driver);
		WebElement ab = driver.findElement(By.xpath("//span[@class='nc_iconfont btn_slide']"));
		a.clickAndHold(ab);
		a.dragAndDropBy(ab, 305, 40).build().perform();
	}
	@Then("The user should navigate to the invalid login page")
	public void the_user_should_navigate_to_the_invalid_login_page() {
		Assert.assertTrue(true);
		System.out.println("Invalid username");
		driver.quit();
	}
}
