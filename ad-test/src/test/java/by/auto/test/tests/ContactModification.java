package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import by.auto.test.model.Contacts;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    Contacts before = app.contact().all();
    ContactObject modifiedContact = before.iterator().next();
    ContactObject contact = new ContactObject().withId(modifiedContact.getId()).withLN(app.group().randomTextGeneration()).withFN(app.group().randomTextGeneration());
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
