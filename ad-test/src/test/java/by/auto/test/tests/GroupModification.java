package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import org.testng.annotations.Test;

/**
 * Created by AlexD on 3/19/2017.
 */
public class GroupModification extends TestBase {
  @Test
  public void testGroupModification(){
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupFields(new GroupObject("5", "5", "5"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
