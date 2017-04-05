package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactDeletion extends TestBase {
  @Test
  public void testContactDeletion(){
    String groupName= "GroupName1";
//    //if (!app.getGroupHelper().isThereGroupByGroupName(groupName)){
//      app.getNavigationHelper().goToGroupPage();
//      app.getGroupHelper().createGroup(new GroupObject(groupName, "1", "2"));
//      app.getNavigationHelper().goToHomePageHeaderLink();
//    //}

    if (! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().clickNewContact();
      app.getContactHelper().createContact(new ContactObject("11", null, "11", "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990", groupName), true);
      app.getNavigationHelper().returnToHomePage();
    }
    List<ContactObject> before = app.getContactHelper().getContactsList();
    int index = before.size()-1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmDeletion();
    app.getNavigationHelper().goToHomePageHeaderLink();
    List<ContactObject> after = app.getContactHelper().getContactsList();
    before.remove(index);
    Comparator<? super ContactObject> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
