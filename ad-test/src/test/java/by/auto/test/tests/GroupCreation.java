package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    List<GroupObject> before = app.getGroupHelper().getGroupList();
    GroupObject group = new GroupObject("1","2", "3");
    app.getGroupHelper().createGroup(group);
    List<GroupObject> after = app.getGroupHelper().getGroupList();
    before.add(group);
    Comparator<? super GroupObject> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

 }
