package by.auto.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by AlexD on 3/19/2017.
 */
public class NavigationHelper extends HelperBase{

  NavigationHelper(WebDriver wd){
    super(wd);
  }

  public void clickNewContact() {
    if (isElementPresent(By.name("submit")) && wd.findElement(By.name("submit")).getText().equals("Enter")){
      return;
    }
    click(By.linkText("add new"));
  }




  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home page"));
  }


}
