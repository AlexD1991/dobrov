package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
    Set<ContactObject> before = app.contact().all();
    ContactObject contact = new ContactObject().withFN(app.group().randomTextGeneration()).withLN(app.group().randomTextGeneration()).withNickName("11").withTitle("Titlererer").withMobile("Mobile").withGroup("GroupName1");
    app.contact().create(contact);
    Set<ContactObject> after = app.contact().all();
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
