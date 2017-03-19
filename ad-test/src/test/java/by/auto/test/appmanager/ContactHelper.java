package by.auto.test.appmanager;

import by.auto.test.model.ContactObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactHelper extends HelperBase{
  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactFields(ContactObject contactObject) {
    type(By.name("firstname"), contactObject.getContactFN());
    type(By.name("middlename"), contactObject.getContactMN());
    type(By.name("lastname"), contactObject.getContactLN());
    type(By.name("nickname"), contactObject.getContactNickName());
    type(By.name("title"), contactObject.getContactTitle());
    type(By.name("company"), contactObject.getContactCompany());
    type(By.name("address"), contactObject.getContactAddress());
    type(By.name("home"), contactObject.getContactHome());
    type(By.name("mobile"), contactObject.getContactMobile());
    type(By.name("work"), contactObject.getContactWork());
    type(By.name("fax"), contactObject.getContactFax());

    if (!checkSelection(By.xpath("//div[@id='content']/form/select[1]//option[7]"))) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[7]"));
    }
    if (!checkSelection(By.xpath("//div[@id='content']/form/select[2]//option[8]"))) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[8]"));
    }
    type(By.name("byear"), contactObject.getContactBirthYear());



    if (!checkSelection(By.xpath("//div[@id='content']/form/select[3]//option[16]"))) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[16]"));
    }
    if (!checkSelection(By.xpath("//div[@id='content']/form/select[4]//option[6]"))) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[6]"));
    }
    type(By.name("ayear"), contactObject.getContactMarryYear());
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmDeletion() {
    try {
      WebDriverWait wait = new WebDriverWait(wd, 2);
      wait.until(ExpectedConditions.alertIsPresent());
      Alert alert = wd.switchTo().alert();
      alert.accept();
    } catch (Exception e) {
      //exception handling
    }
  }

  public void initContactEdition() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactEdition() {
    click(By.name("update"));
  }
}
