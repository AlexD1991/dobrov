package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import by.auto.test.model.Groups;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

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

    Groups before = app.group().all();
    GroupObject deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size()-1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }


}
