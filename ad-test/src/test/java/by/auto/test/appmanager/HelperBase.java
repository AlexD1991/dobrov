package by.auto.test.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by AlexD on 3/19/2017.
 */
public class HelperBase {
  WebDriver wd;

  HelperBase(WebDriver wd) {
    this.wd=wd;
  }

  void click(By locator) {
    wd.findElement(locator).click();
  }

  void type(By locator, String text) {
    click(locator);
    if (text!=null){
      String currentText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(currentText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }



  boolean checkSelection(By locator) {
    return wd.findElement(locator).isSelected();
  }

  public  boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  boolean isElementPresent (By locator){
    try{
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex){
      return false;
    }
  }
  public String randomTextGeneration() {
    SecureRandom random = new SecureRandom();
    return new BigInteger(50, random).toString(32);
  }

  public void goToGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && isElementPresent(By.name("new"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")){
      return;
    }
    click(By.linkText("groups"));
  }

  public void goToHomePageHeaderLink() {
    click(By.linkText("home"));
  }
}
