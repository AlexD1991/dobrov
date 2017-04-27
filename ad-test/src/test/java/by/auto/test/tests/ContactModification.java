package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactModification extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().list().size()==0){
      app.contact().clickNew();
      app.contact().create(new ContactObject().withLN(app.group().randomTextGeneration()).withFN(app.group().randomTextGeneration()).withCompany("11").withGroup("GroupName1"), true);
      app.contact().returnToHomePage();
    }
  }

  @Test
  public void testContactModification(){

    Set<ContactObject> before = app.contact().all();
    ContactObject modifiedContact = before.iterator().next();
    ContactObject contact = new ContactObject().withId(modifiedContact.getId()).withLN(app.group().randomTextGeneration()).withFN(app.group().randomTextGeneration());
    app.contact().modify(contact);
    Set<ContactObject> after = app.contact().all();
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }

}
