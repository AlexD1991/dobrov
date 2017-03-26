package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import org.testng.annotations.Test;

public  class ContactCreation extends TestBase{

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().clickNewContact();
    app.getContactHelper().fillContactFields(new ContactObject("11", null, "11", "11", "11", "11", "1", "1", "", "1", "1", "2000", "1990", "GroupName1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }

}
