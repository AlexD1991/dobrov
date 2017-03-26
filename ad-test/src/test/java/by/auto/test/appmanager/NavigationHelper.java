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

  public void goToGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && isElementPresent(By.name("new"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")){
      return;
    }
    click(By.linkText("groups"));
  }


  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home page"));
  }

  public void goToHomePageHeaderLink() {
    click(By.linkText("home"));
  }
}
