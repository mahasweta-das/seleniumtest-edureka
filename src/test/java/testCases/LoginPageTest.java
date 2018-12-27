package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import model.LoginPage;
import testbase.TestBase;

public class LoginPageTest extends TestBase{
 LoginPage loginpage;
	@BeforeClass
	public void setup(){
		init();
		loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void verifyPageTitle(){
		st.assertEquals(loginpage.validateLoginPageTitle(),"Login");
	}
	@Test(priority=2)
	public void verifySubmit(){
		st.assertTrue(loginpage.login(prop.getProperty("userid"), prop.getProperty("password")));
	}
	@AfterClass
	public void tearDown(){
		destroy();
	}

	
}
