package domi.testMonPresta;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.touch.*;

import java.net.MalformedURLException;
import java.net.URL;

public class prestashopTest {
  private WebDriver driver;  
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private HashMap<String, Object> vars;

  final static Logger logger = Logger.getLogger(domi.testMonPresta.prestashopTest.class);



  @Before
  public void setUp() throws Exception {
	  
//    FirefoxOptions options = new FirefoxOptions();
//	FirefoxProfile monProfil = new FirefoxProfile(new File("/Users/dominiquemereaux/Library/Application Support/Firefox/Profiles/zb6qfwx8.monProfil"));
//	options.setProfile(monProfil); 
//	WebDriver driver2 = new FirefoxDriver(options);
//	 Proxy proxy = new Proxy();

	
	
//	ChromeOptions options = new ChromeOptions();
//	options.setHeadless(true);
//	options.setProxy(proxy);


	  
//	DesiredCapabilities capa = DesiredCapabilities.firefox();
	System.setProperty("webdriver.chrome.driver", "/Users/dominiquemereaux/code/driver/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    
    
  }
  public String waitForWindow(int timeout) {
	    try {
	      Thread.sleep(timeout);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    Set<String> whNow = driver.getWindowHandles();
	    Set<String> whThen = (Set<String>) vars.get("window_handles");
	    if (whNow.size() > whThen.size()) {
	      whNow.removeAll(whThen);
	    }
	    return whNow.iterator().next();
	  }
// ouvrir la page et vérifier le titre
@Test 
  public void ouvrirLaPage() throws InterruptedException {
 	    driver.get("http://prestashop.qualifiez.fr/en/");
 	    driver.manage().window().setSize(new Dimension(968, 699));
 	    driver.manage().window().maximize();

 	  }  

// Recherche MUG
// Verifier le titre de la page
// verifier le texte
// verifier l'attribut value dans le champ de recherche
@Test 
 public void chercherLeMug() throws InterruptedException {
	    driver.get("http://prestashop.qualifiez.fr/en/");
	    driver.manage().window().setSize(new Dimension(968, 699));
	    driver.manage().window().maximize();
	    driver.findElement(By.name("s")).sendKeys("MUG");
	    driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
	    assertEquals(driver.getTitle(),"Search");	 
	    assertEquals(driver.findElement(By.name("s")).getAttribute("Value"),"MUG");
	    assertEquals(driver.findElement(By.xpath("//*[@id='js-product-list-top']/div[1]/p")).getText(),"There are 5 products.");	    


	  }
// checker la Box et vérifier quelle est bien checkée
//@Test 
public void checkerLaBOX() throws InterruptedException {
	    driver.get("http://prestashop.qualifiez.fr/en/men/1-1-hummingbird-printed-t-shirt.html#/1-size-s/8-color-white");

	    
}
// Fermer la fenetre modale (id = accept-choices)
// Aller sur la frame et prendre une photo de la frame
// Utilisation de de Logger
//@Test 
public void laFrame() throws InterruptedException, IOException {

	logger.info("Etape 1 : " + "aller sur le site");

	driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
	logger.info("Etape 2 : " + "accepter la modale");
	driver.findElement(By.id("accept-choices")).click();
// photo du site	
	TakesScreenshot  srcPhoto = ((TakesScreenshot)driver);
	File filePhoto = srcPhoto.getScreenshotAs(OutputType.FILE);
	File destFile = new File("./toto.png");
	FileUtils.copyFile(filePhoto, destFile);
	
	
}
 
//@Test 
 public void chercherLeMugAvecBouton() throws MalformedURLException {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("sessionName", "Automation test session on android web");
	  capabilities.setCapability("sessionDescription", "This is example android web testing"); 
	  capabilities.setCapability("deviceOrientation", "portrait"); 
	  capabilities.setCapability("platformName", "android"); 
	  capabilities.setCapability("browserName", "chrome"); 
	  capabilities.setCapability("deviceName", "toto");
	  capabilities.setCapability("platformVersion", "10");
	  
	  // Création d'un remote driver pour se connecter au serveur APPIUM
	  RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.get("http://prestashop.qualifiez.fr/en/");

	    driver.findElement(By.name("s")).sendKeys("MUG");
	    driver.findElement(By.cssSelector("#search_widget > form > button > i")).click();
	    assertEquals(driver.getTitle(),"Search");	   
	  }
// Compter les fenêtres
// Clicker sur le bouton "btnNewWindow"
// recompter les fenêtres
//@Test
  public void compterLesFenetres() {
	
    driver.get("http://www.qualifiez.fr/examples/Selenium/project-list.php");
    driver.manage().window().setSize(new Dimension(968, 699));
    driver.manage().window().maximize();
    // recuperation des handles de fenetres
    // recuperation des handles de fenetres
    // je vais sur la fenêtre en utilisant le nom dans le code source
    // je vais sur la fenetre en utilisant le Handle
  
  }
   // Utilisation de la classe action pour survoler le lien Clothes
  @Test
  public void testActions() throws Exception {
	    driver.get("http://prestashop.qualifiez.fr/en/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		Action mouseOverClothes = builder.moveToElement(driver.findElement(By.cssSelector("#category-3 > a:nth-child(1)"))).build();
		mouseOverClothes.perform();
        assertTrue(driver.findElement(By.xpath("//*[@id='category-4']/a")).isDisplayed());
		
 
        
  } 
//@Test
  // Faire une copie ecran.
  public void testPrestashop1() throws Exception {
	    driver.manage().window().setSize(new Dimension(1050, 840));
	    // creation objet pour faire des copies ecran
	    // copie ecran, resultat dans un objet de type FILE
//	    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	    // creation d'un fichier sur C:
//	    File DestFile=new File("C:/TP/toto.png");
        //Copie de la copie ecran dans dans le fichier 
//        FileUtils.copyFile(SrcFile, DestFile);
 }

 
 //@Test
  // correction MUG
  public void testPrestashop7() throws Exception {
	  // Aller sur la page prestashop
	  driver.get("http://prestashop.qualifiez.fr/en/");
	  // saisir le champ de recherche
      driver.findElement(By.name("s")).sendKeys("MUG");
      // cliquer sur le bouton de recherche
	  driver.findElement(By.cssSelector("button > .search")).click();  
	  // attendre et contrôler le résultat
	  assertEquals(driver.findElement(By.cssSelector(".total-products > p")).getText(),"There are 5 products.");
  }


  
//@Test
  // utilisation de findElements
  public void testPrestashopCurrency() throws Exception {
	  
	  // Aller sur la page prestashop
	  driver.get("http://prestashop.qualifiez.fr/en/");
	  
	  // recuperer les liens a vers des devises
      List<WebElement> list = driver.findElements(By.xpath("//*[@id='_desktop_currency_selector']/div/ul//a"));
      for (WebElement elt : list)
      {
    	  System.out.println("list:");
    	  System.out.println(elt.getAttribute("Title"));
    	  System.out.println(elt.getAttribute("outerHTML"));
     }

  }
  
//@Test
  // exemple javascript
  public void testJavascript() throws Exception {
	  driver.get("http://prestashop.qualifiez.fr/en/");
	  JavascriptExecutor js1 = (JavascriptExecutor) driver;
	  // saisie de MUG
	  js1.executeScript("document.getElementsByName('s')[0].value='MUG';");
	  // click sur bouton
	  js1.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("button > .search")));
	  driver.findElement(By.cssSelector("button > .search")).click();  
	  assertEquals(driver.findElement(By.cssSelector(".total-products > p")).getText(),"There are 5 products.");
   }
  
//@Test
 //fenetre correction
  public void testFenetre() throws Exception {
	  driver.get("http://www.qualifiez.fr/examples/Selenium/project-list.php");
	  //compter les fenetre
	  assertEquals(driver.getWindowHandles().size(),1);
	  driver.findElement(By.id("btnNewWindow")).click();
	  Set<String> whNow = driver.getWindowHandles();
	  // compter les fenêtres 
	  assertEquals(driver.getWindowHandles().size(),2);
	  // aller sur la deuxième fenêtre
	  driver.switchTo().window("toto");
	  assertThat(driver.findElement(By.cssSelector("p")).getText(), is("New Window ..."));
 }

  
//@Test
  
  // correction des alertes Traitement des alertes
  public void testPrestashop4() throws Exception {
	    driver.get("http://www.qualifiez.fr/examples/Selenium/project-list.php");
	    driver.findElement(By.id("btnAlert")).click();
	    assertThat(driver.switchTo().alert().getText(), is("Info"));
	    Alert monPopup = driver.switchTo().alert();
	    monPopup.accept();
	     }
  //@Test exempla de configuration pour un test sur mobile
  public void testPrestashopR() throws Exception {
	  
	  // Definition du mobile sur lequel on va exécuter les tests
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("sessionName", "Automation test session on android web");
	  capabilities.setCapability("sessionDescription", "This is example android web testing"); 
	  capabilities.setCapability("deviceOrientation", "portrait"); 
	  capabilities.setCapability("platformName", "android"); 
	  capabilities.setCapability("browserName", "chrome"); 
	  capabilities.setCapability("deviceName", "toto");
	  capabilities.setCapability("platformVersion", "10");
	  
	  // Création d'un remote driver pour se connecter au serveur APPIUM
	  RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  
	  // demarage du test
	  driver.get("http://www.qualifiez.fr/examples/Selenium/project-list.php");
	  
	  WebElement element = driver.findElement( By.xpath("/html/body/div/a"));
	  
	  TouchActions action = new TouchActions(driver);
	  action.singleTap(element);
	  action.perform();

	  driver.findElement(By.id("btnAlert")).click();
	  assertThat(driver.switchTo().alert().getText(), is("Info"));
	  Alert monPopup = driver.switchTo().alert();
	  monPopup.accept();



	  
	     }
  @After
  public void tearDown() throws Exception {
    driver.quit();
    
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {


        alert.accept();

      } else {

        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
