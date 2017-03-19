package by.auto.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by AlexD on 3/19/2017.
 */
public class NavigationHelper extends HelperBase{
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd){
    super(wd);
  }

  public void clickNewContact() {
    click(By.linkText("add new"));
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }
}
