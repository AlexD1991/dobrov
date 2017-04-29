package by.auto.test.tests;

import by.auto.test.model.GroupObject;
import by.auto.test.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.attribute.GroupPrincipal;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by AlexD on 3/19/2017.
 */
public class GroupModification extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size()==0){
      app.group().create(new GroupObject().withName(app.group().randomTextGeneration()).withFooter(app.group().randomTextGeneration()).withHeader(app.group().randomTextGeneration()));
    }
  }

  @Test
  public void testGroupModification(){
    Groups before = app.group().all();
    GroupObject modifiedGroup = before.iterator().next();
    GroupObject group = new GroupObject().withId(modifiedGroup.getId()).withName(app.group().randomTextGeneration()).withFooter(app.group().randomTextGeneration()).withHeader(app.group().randomTextGeneration());
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }
}
