package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import org.testng.annotations.Test;

/**
 * Created by AlexD on 3/19/2017.
 */
public class GroupDeletion extends TestBase {
  @Test
  public void testGroupDeletion(){
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupObject("test1","Test2","Test3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
