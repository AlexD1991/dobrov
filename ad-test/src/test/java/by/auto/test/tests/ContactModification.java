package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactModification extends TestBase {
  @Test
  public void testContactModification(){
    if (!app.getContactHelper().isThereContact()){
      app.getNavigationHelper().clickNewContact();
      app.getContactHelper().createContact(new ContactObject("11", null, "11", "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990", "GroupName1"), true);
      app.getNavigationHelper().returnToHomePage();
    }
    List<ContactObject> before = app.getContactHelper().getContactsList();
    int index = before.size()-1;
    app.getContactHelper().initContactEdition(index);
    ContactObject contact = new ContactObject(app.getGroupHelper().randomTextGeneration(), "12", app.getGroupHelper().randomTextGeneration(), "2", "211", "121", "12", "12", "2", "21", "21", "2200", "1290", null);
    app.getContactHelper().fillContactFields(contact, false);
    app.getContactHelper().submitContactEdition();
    app.getNavigationHelper().goToHomePageHeaderLink();
    List<ContactObject> after = app.getContactHelper().getContactsList();
    before.remove(index);
    before.add(contact);

    Comparator<? super ContactObject> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
