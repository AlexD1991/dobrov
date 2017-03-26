package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import org.testng.annotations.Test;

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
    app.getContactHelper().initContactEdition();
    app.getContactHelper().fillContactFields(new ContactObject("12", "12", "21", "2", "211", "121", "12", "12", "2", "21", "21", "2200", "1290", null), false);
    app.getContactHelper().submitContactEdition();

  }


}
