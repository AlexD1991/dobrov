package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.*;

public  class ContactCreation extends TestBase{


  @Test
  public void testContactCreation() {
    List<ContactObject> before = app.getContactHelper().getContactsList();

    String groupFind = "GroupName1";
    if (!app.getContactHelper().checkSpecificGroupPresentAndReturnToHomePage(groupFind)){
      app.getNavigationHelper().goToGroupPage();
      GroupObject group = new GroupObject(groupFind,app.getGroupHelper().randomTextGeneration(), app.getGroupHelper().randomTextGeneration());
      app.getGroupHelper().createGroup(group);
      app.getNavigationHelper().goToHomePageHeaderLink();
    }
    app.getNavigationHelper().clickNewContact();
    ContactObject contact = new ContactObject(app.getGroupHelper().randomTextGeneration(), null, app.getGroupHelper().randomTextGeneration(), "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990", groupFind);
    app.getContactHelper().createContact(contact, true);
    app.getNavigationHelper().returnToHomePage();
    List<ContactObject> after = app.getContactHelper().getContactsList();
    before.add(contact);


    Comparator<? super ContactObject> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
