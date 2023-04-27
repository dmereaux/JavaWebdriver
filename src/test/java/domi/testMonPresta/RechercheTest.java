package domi.testMonPresta;


import static org.junit.Assert.*;

import org.junit.Test;
import java.io.StringReader;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;


public class RechercheTest {
	  private static WebDriver driver;
	  private static String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private pageAccueil accueil;




	  @Before
	 public void setUp() throws Exception {
		  
		// creation du driver
			System.setProperty("webdriver.gecko.driver", "geckodriver");
		    driver = new FirefoxDriver();
		    baseUrl = " http://prestashop.qualifiez.fr/en/";

	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);

		accueil =  PageFactory.initElements(driver, pageAccueil.class);
		  
	};

	// Create a test using SignInPage and PageProject to check successful login  
	@Test
	public void testRecherche() throws Exception {
		fail();
	}
	@Test
	public void testRechercheInfructueuse() throws Exception {
		fail();
	}
	

	  @After
	 public  void tearDown() throws Exception {
	    driver.quit();
	  }




	}



