package by.auto.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by AlexD on 3/19/2017.
 */
public class NavigationHelper {
  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd){
    this.wd=wd;
  }

  public void clickNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}
