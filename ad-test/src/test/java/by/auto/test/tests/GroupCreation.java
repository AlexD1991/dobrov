package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import org.testng.annotations.Test;

public class GroupCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupObject("1","2", "3"));
  }

 }
