package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by AlexD on 3/19/2017.
 */
public class GroupModification extends TestBase {
  @Test
  public void testGroupModification(){
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupObject(app.getGroupHelper().randomTextGeneration(),app.getGroupHelper().randomTextGeneration(),app.getGroupHelper().randomTextGeneration()));
    }
    List<GroupObject> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupObject group = new GroupObject(before.get(before.size()-1).getId(),app.getGroupHelper().randomTextGeneration(), app.getGroupHelper().randomTextGeneration(), app.getGroupHelper().randomTextGeneration());
    app.getGroupHelper().fillGroupFields(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupObject> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size()-1);
    before.add(group);
    Comparator<? super GroupObject> byId = (g1,g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
