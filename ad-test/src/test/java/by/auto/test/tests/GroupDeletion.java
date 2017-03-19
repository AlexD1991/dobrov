package by.auto.test.tests;

import org.testng.annotations.Test;

/**
 * Created by AlexD on 3/19/2017.
 */
public class GroupDeletion extends TestBase {
  @Test
  public void testGroupDeletion(){
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
