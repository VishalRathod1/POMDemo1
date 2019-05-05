package MercuryTS_main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import MercuryTS_Config.Config;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MercuryTS_mainTest {
	
	@When("^user opens \"(.*)\" browser$")
	public void openBrowser(String browsernm){
		if(browsernm.equalsIgnoreCase("chrome")){
			System.out.println("Chrome browser");
			System.setProperty("webdriver.chrome.driver", "E:\\16122018\\chromedriver_win32\\chromedriver.exe");
			Config.driver=new ChromeDriver();
			System.out.println("Chrome browser is opened successfully");
		}
		else if (browsernm.equalsIgnoreCase("ie")) {
			System.out.println("InternetExplorer browser");
			System.setProperty("webdriver.ie.driver", "E:\\16122018\\IEDriverServer_x64_3.14.0 (10)\\IEDriverServer.exe");
			Config.driver=new InternetExplorerDriver();
			System.out.println("InternetExplorer browser is opened successfully");
		}
		else {
			System.out.println("FireFox browser");
			System.setProperty("webdriver.gecko.driver", "E:\\16122018\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			Config.driver=new FirefoxDriver();
			System.out.println("FireFox browser is opened successfully");
		}
	}
	
	@And("^user enters application url as \"(.*)\"$")
	public void enterApplicationUrl(String url){
		Config.driver.get(url);
	}
	
	@And("^user waits for \"(.*)\" seconds to load login page$")
	public void waitTillLoginPageLoaded(int timesecond){
		Config.driver.manage().timeouts().pageLoadTimeout(timesecond, TimeUnit.SECONDS);
	}
	
	@And("^user maximizes the window$")
	public void maximizeWindow(){
		Config.driver.manage().window().maximize();
	}
	
	@Then("^user is on login page$")
	public void verifyLoginPage(){
		String exp_title="Welcome: Mercury Tours";
		String act_title=Config.driver.getTitle();
		Assert.assertEquals(exp_title, act_title);
		System.out.println("The title of login page is"+act_title);
	}
	
	@Given("^user access login page$")
	public void verifyLoginImg(){
		boolean act_flag=Config.driver.findElement(By.xpath("//img[@src='/images/featured_destination.gif']")).isDisplayed();
		if(act_flag==true){
			System.out.println("Login page is displayed");
		}
		
	}
	
	@When("^user enters \"(.*)\" as username$")
	public void enterUsername(String username){
		Config.driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	}
	
	@And("^user enters \"(.*)\" as password$")
	public void enterPassword(String password){
		Config.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}
	
	@And("^user clicks on Signin button$")
	public void clickOnSignin(){
		Config.driver.findElement(By.xpath("//input[@name='login']")).click();
	}
	
	@Then("^user is on Flight finder page$")
	public void verifyFlightFinderPage(){
		boolean act_flag1= Config.driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
		boolean exp_flag1=true;
		Assert.assertEquals(exp_flag1, act_flag1);
	}
	
	@When("^user clicks on Signoff button$")
	public void clickOnSignoff(){
		Config.driver.findElement(By.linkText("SIGN-OFF")).click();
	}
	
	@Then("^user is on Signon page$")
	public void verifySignonPage(){
		boolean act_flag2=Config.driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']")).isDisplayed();
		if(act_flag2==true){
			System.out.println("Useris on sign on page");
		}
	}

}
