package by.auto.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by AlexD on 3/19/2017.
 */
public class SessionHelper extends HelperBase{
  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }
  public void login(String loginName, String loginPassword) {
    type(By.name("user"), loginName);
    type(By.name("pass"), loginPassword);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }

}
