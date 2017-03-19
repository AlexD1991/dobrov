package by.auto.test.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by AlexD on 3/19/2017.
 */
public class SessionHelper {
  private FirefoxDriver wd;
  public SessionHelper(FirefoxDriver wd) {
    this.wd=wd;
  }
}
