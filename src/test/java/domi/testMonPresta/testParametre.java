package domi.testMonPresta;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

@RunWith(Parameterized.class)
public class testParametre{
	
  private WebDriver driver;
 
  // Ces variables privees sont mises a jour par le constructeur
  private String mot;
  private String resultat;
 
// les jeux de donnees sont crees a partir d un fichier XML 
	@Parameters public static Collection<Object[]> val() {
		return Arrays.asList(new Object[][] {{},{}});
	}
// les variables doivent respectees l'ordre dans la collection
  public testParametre(String motLocal, String resultatLocal)
  {

  }

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "geckodriver");
    driver = new FirefoxDriver();
    driver.get("http://prestashop.qualifiez.fr/en/");
  }
  @Test
  public void testPrestashop() throws Exception {
  } 

  
  @After
  public void tearDown() throws Exception {
    driver.quit();
  }
}
