package domi.testMonPresta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {
	
	void checkLaBox(WebElement elt)
	{
		if (!elt.isSelected())
			elt.click();
	}
	void deCheckLaBox(WebElement elt)
	{
		if (elt.isSelected())
			elt.click();
	}


}
