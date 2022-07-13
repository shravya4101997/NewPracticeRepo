package stepDefinations;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefination extends base {

	 public static WebDriver driver;

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Shravya\\Desktop\\chromiumdriver\\chromedriver_win32\\chromedriver.exe");
	       driver = new ChromeDriver();
	      
	       
	}

	 @And("^Navigate to Site$")
	    public void navigate_to_site() throws Throwable {
		 driver.get("https://www.saucedemo.com/");
	      driver.manage().window().maximize();
	    }
	 @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 driver.findElement(By.id("user-name")).sendKeys(username);
		 driver.findElement(By.id("password")).sendKeys(password);
		 driver.findElement(By.id("login-button")).click();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    }

	

	@Then("^Verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable {
			String actualurl="https://www.saucedemo.com/inventory.html";
			String expectedurl=driver.getCurrentUrl();
			Assert.assertEquals(expectedurl,actualurl);
	
	    }
	 @Then("^Verify that user has not logged in$")
	    public void verify_that_user_has_not_logged_in() throws Throwable {
//	        String expectedresult="Epic sadface: Username and password do not match any user in this service";
//	        WebElement actualresult =driver.findElement(By.xpath("//button[@class='error-button']"));
//	        String act=actualresult.getText();
//	        System.out.println("Error message:"+act);
//	        Assert.assertEquals(expectedresult,act);
	 }

	    @Given("^automate the dropdown and do all actions$")
	    public void automate_the_dropdown_and_do_all_actions() throws Throwable {
	    	String text = null;
	    	 WebElement dropdownlist=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
	    	 Select s=new Select(dropdownlist);
	    	 List<WebElement>options=s.getOptions();
	    	 for(WebElement w:options) {
	    		 try {
	    		 text=w.getText();
	    		 }
	    		 catch(StaleElementReferenceException exp) {
	    		 System.out.println(text);
	    		 s.selectByVisibleText("Name (Z to A)");
	    		 }
	    		 
	    	 }
	    	 
	    }

	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
		 driver.close();
		 driver.quit();
	    }
	

}
