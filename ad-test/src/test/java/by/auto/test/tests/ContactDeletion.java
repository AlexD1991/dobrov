package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.auto.test.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by AlexD on 3/19/2017.
 */
public class ContactDeletion extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (! app.contact().present()){
      app.contact().clickNew();
      app.contact().create(new ContactObject().withLN(app.group().randomTextGeneration()).withFN(app.group().randomTextGeneration()).withCompany("11").withGroup("GroupName1"), true);
      app.contact().returnToHomePage();
    }
  }

  @Test
  public void testContactDeletion(){
    Contacts before = app.contact().all();
    ContactObject deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size()-1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
