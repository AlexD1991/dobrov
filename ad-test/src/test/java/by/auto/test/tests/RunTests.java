package by.auto.test.tests;

import by.auto.test.appmanager.ApplicationManager;
import by.auto.test.model.ContactObject;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.auto.test.model.GroupObject;
import org.testng.annotations.TestInstance;

/**
 * Created by AlexD on 3/25/2017.
 */

public class RunTests extends TestBase {
  @Test
  public void testContactCreation1() {
    ContactCreation test = new ContactCreation();
    test.testContactCreation();
  }

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().clickNewContact();
    app.getContactHelper().createContact(new ContactObject("11", null, "11", "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990", "GroupName1"), true);
    app.getNavigationHelper().returnToHomePage();
  }

  @Test
  public void testContactDeletion() {
    String groupName = "GroupName1";
    //if (!app.getGroupHelper().isThereGroupByGroupName(groupName)){
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupObject(groupName, "1", "2"));
    app.getNavigationHelper().goToHomePageHeaderLink();
    //}

    if (!app.getContactHelper().isThereContact()) {
      app.getNavigationHelper().clickNewContact();
      app.getContactHelper().createContact(new ContactObject("11", null, "11", "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990", groupName), true);
      app.getNavigationHelper().returnToHomePage();
    }
//    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmDeletion();
  }

  @Test
  public void testContactModification() {
    if (!app.getContactHelper().isThereContact()) {
      app.getNavigationHelper().clickNewContact();
      app.getContactHelper().createContact(new ContactObject("11", null, "11", "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990", "GroupName1"), true);
      app.getNavigationHelper().returnToHomePage();
    }
    //app.getContactHelper().initContactEdition();
    app.getContactHelper().fillContactFields(new ContactObject("12", "12", "21", "2", "211", "121", "12", "12", "2", "21", "21", "2200", "1290", null), false);
    app.getContactHelper().submitContactEdition();

  }

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupObject("1", "2", "3"));
  }

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupObject("test1", "Test2", "Test3"));
    }
//    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupObject("test1", "Test2", "Test3"));
    }
//    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupFields(new GroupObject("5", "5", "5"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
