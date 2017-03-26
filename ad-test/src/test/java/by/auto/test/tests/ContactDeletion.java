package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import by.auto.test.model.GroupObject;
import org.testng.annotations.Test;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactDeletion extends TestBase {
  @Test
  public void testContactDeletion(){
    String groupName= "GroupName1";
    //if (!app.getGroupHelper().isThereGroupByGroupName(groupName)){
      app.getNavigationHelper().goToGroupPage();
      app.getGroupHelper().createGroup(new GroupObject(groupName, "1", "2"));
      app.getNavigationHelper().goToHomePageHeaderLink();
    //}

    if (! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().clickNewContact();
      app.getContactHelper().createContact(new ContactObject("11", null, "11", "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990", groupName), true);
      app.getNavigationHelper().returnToHomePage();
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmDeletion();
  }
}
