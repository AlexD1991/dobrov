package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreation extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Set<GroupObject> before = app.group().all();
    GroupObject group = new GroupObject().withName(app.group().randomTextGeneration()).withFooter(app.group().randomTextGeneration()).withHeader(app.group().randomTextGeneration());
    app.group().create(group);
    Set<GroupObject> after = app.group().all();
    group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before,after);
  }

 }
