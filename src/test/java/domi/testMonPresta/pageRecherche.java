package domi.testMonPresta;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class pageRecherche {

	private WebDriver driverRecherche;
	@FindBy(how = How.CSS, using = ".total-products > p")
    private WebElement resRecherche;

	public pageRecherche(WebDriver driverAccueil) {
		driverRecherche = driverAccueil;
	    if ("presta-recherche".contentEquals(driverRecherche.getTitle()))
	    { throw new IllegalStateException ("pas la page pour se connecter" +driverAccueil.getTitle() ); 	}
	}
   public String nbElementTrouve()
   {
	return null;

   }
   public String PasDeResultat()
   
   {
	return null;

   }
   public pageRecherche trier(String item)
   {

	   return this;
   }


}
