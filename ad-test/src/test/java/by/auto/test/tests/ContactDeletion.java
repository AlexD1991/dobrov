package by.auto.test.tests;

import org.testng.annotations.Test;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactDeletion extends TestBase {
  @Test
  public void testContactDeletion(){
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().confirmDeletion();
  }
}
