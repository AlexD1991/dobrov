package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactDeletion extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (! app.contact().isThereContact()){
      app.contact().clickNew();
      app.contact().create(new ContactObject().withLN(app.group().randomTextGeneration()).withFN(app.group().randomTextGeneration()).withCompany("11").withGroup("GroupName1"), true);
      app.contact().returnToHomePage();
    }
  }

  @Test
  public void testContactDeletion(){
    Set<ContactObject> before = app.contact().all();
    ContactObject deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactObject> after = app.contact().all();
    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}
