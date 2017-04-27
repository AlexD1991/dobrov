package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by AlexD on 3/19/2017.
 */
public class GroupDeletion extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size()==0){
      app.group().create(new GroupObject().withName(app.group().randomTextGeneration()).withFooter(app.group().randomTextGeneration()).withHeader(app.group().randomTextGeneration()));
    }
  }

  @Test
  public void testGroupDeletion(){

    Set<GroupObject> before = app.group().all();
    GroupObject deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupObject> after = app.group().all();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }


}
