package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import org.testng.annotations.Test;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactModification extends TestBase {
  @Test
  public void testContactModification(){
    app.getContactHelper().initContactEdition();
    app.getContactHelper().fillContactFields(new ContactObject("12", "12", "21", "2", "211", "121", "12", "12", "2", "21", "21", "2200", "1290", null), false);
    app.getContactHelper().submitContactEdition();

  }


}
