package testbase;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String currentDirectory;
	public static WebDriverWait wait;
	public static Actions builder;
	public static SoftAssert st;
	public static String timeStamp;
	
	//setup log4j, set browser, setup EventFiringWebDriver and WebDriverEventListener, maximize window, deleteAllCookies, Pageload timeout, Implicit Timeout 
	public void init(){
		st=new SoftAssert();
		timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		prop=new Properties();
		currentDirectory=System.getProperty("user.dir");
		System.out.println("Initializing in "+currentDirectory);
		try {
			FileInputStream ip=new FileInputStream(currentDirectory+"/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			st.fail("Failed in TestBase method:init-"+e.getLocalizedMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			st.fail("Failed in TestBase method:init-"+e.getLocalizedMessage());
		}
		System.out.println("Initializing::::"+currentDirectory);
		String browser=prop.getProperty("browser");
                System.out.println("Browser="+browser);
		String driverpath=currentDirectory+"/";
		System.setProperty("webdriver.gecko.driver", driverpath+"geckodriver");
		//System.setProperty("webdriver.gecko.driver","/usr/local/sbin/geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver,120);
		String url=prop.getProperty("url");
		System.out.println("Initializing URL "+url);
		driver.get(url);			
	}	
	public void destroy(){
		driver.quit();
	}
	
}
