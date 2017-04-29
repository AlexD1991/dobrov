package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.auto.test.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public  class ContactCreation extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    if (!app.contact().checkSpecificGroupPresentAndReturnToHomePage("GroupName1")){
      app.goTo().groupPage();
      GroupObject group = new GroupObject().withName("GroupName1");
      app.group().create(group);
      app.goTo().goToHomePageHeaderLink();
    }
  }

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactObject contact = new ContactObject().withFN(app.group().randomTextGeneration()).withLN(app.group().randomTextGeneration()).withNickName("11").withTitle("Titlererer").withMobile("Mobile").withGroup("GroupName1");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
  }

}
