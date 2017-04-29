package by.auto.test.appmanager;

import by.auto.test.model.ContactObject;
import by.auto.test.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactHelper extends HelperBase{

  ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactFields(ContactObject contactObject, boolean creation) {
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

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactObject.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }



  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='"+id+"']")).click();
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
  }

  public void initContactEdition(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id="+id+"']")).click();
  }

  public void submitContactEdition() {
    click(By.name("update"));
  }

  public void create(ContactObject contact, boolean creation) {
    fillContactFields(contact, creation);
    submitContactCreation();
    contactsCache = null;
  }

  public boolean present() {
    return (isElementPresent(By.name("selected[]")) && isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")));
  }

  public List<ContactObject> list() {
    List<ContactObject> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String lastName = element.findElements(By.tagName("td")).get(1).getText();
      String firstName = element.findElements(By.tagName("td")).get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      System.out.println(lastName+" "+ firstName+" "+id);
      contacts.add(new ContactObject().withId(id).withFN(firstName).withLN(lastName));
    }
    return contacts;
  }

  private Contacts contactsCache = null;

  public Contacts all() {
    if (contactsCache!=null){
      return new Contacts(contactsCache);
    }

    contactsCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String lastName = element.findElements(By.tagName("td")).get(1).getText();
      String firstName = element.findElements(By.tagName("td")).get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String allPhones = element.findElements(By.tagName("td")).get(5).getText();
      ContactObject contact = new ContactObject().withId(id).withFN(firstName).withLN(lastName).withAllPhones(allPhones);
      contactsCache.add(contact);
    }
    return new Contacts(contactsCache);
  }

  public boolean checkSpecificGroupPresentAndReturnToHomePage(String group) {
    groupPage();
    List<WebElement> find = wd.findElements(By.cssSelector("span.group"));
    for (WebElement i : find){
      if (i.getText().equals(group)){
        goToHomePageHeaderLink();
        return true;
      }
    }
    goToHomePageHeaderLink();
    return false;
  }

  public void create(ContactObject contact) {
    clickNew();
    create(contact, true);
    contactsCache = null;
    returnToHomePage();
  }

  public void clickNew() {
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

  public void modify(ContactObject contact) {
    initContactEdition(contact.getId());
    fillContactFields(contact, false);
    submitContactEdition();
    contactsCache = null;
    goToHomePageHeaderLink();
  }

  public void delete(ContactObject contact) {
    selectContactById(contact.getId());
    deleteContact();
    confirmDeletion();
    contactsCache = null;
    goToHomePageHeaderLink();
  }

  public int count(){
    return wd.findElements(By.name("selected[]")).size();
  }

  public ContactObject infoFromEditForm(ContactObject contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String phoneHome1 = wd.findElement(By.name("home")).getAttribute("value");
    String phoneMobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String phoneWork = wd.findElement(By.name("work")).getAttribute("value");
    String phoneHome2 = wd.findElement(By.name("phone2")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    return new ContactObject().withFN(firstName).withLN(lastName).withAddress(address).withHome(phoneHome1)
            .withMobile(phoneMobile).withWork(phoneWork).withHome2(phoneHome2).withEmail1(email1).withEmail2(email2).withEmail3(email3);
  }

  public void initContactModificationById(int id){
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
}
