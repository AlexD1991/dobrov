package by.auto.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreation {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    login("admin", "secret");
  }

  @Test
  public void ContactCreation() {
    clickNewContact();
    fillContactFields(new ContactObject("11", "11", "11", "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990"));
    submitContactCreation();
    returnToHomePage();
  }

  private void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactFields(ContactObject contactObject) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactObject.getContactFN());
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(contactObject.getContactMN());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactObject.getContactLN());
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactObject.getContactNickName());
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(contactObject.getContactTitle());
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(contactObject.getContactCompany());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactObject.getContactAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactObject.getContactHome());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactObject.getContactMobile());
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(contactObject.getContactWork());
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(contactObject.getContactFax());

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[7]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[8]")).click();
    }
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(contactObject.getContactBirthYear());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[16]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[16]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[6]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[6]")).click();
    }
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys(contactObject.getContactMarryYear());
  }

  private void clickNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void login(String loginName, String loginPassword) {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(loginName);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(loginPassword);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
