package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

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
    List<GroupObject> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    app.getGroupHelper().selectGroup(index);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupObject> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
    Comparator<? super GroupObject> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
