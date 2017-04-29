package by.auto.test.appmanager;

import by.auto.test.model.GroupObject;
import by.auto.test.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by AlexD on 3/19/2017.
 */
public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void sumbitNewGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupFields(GroupObject groupObject) {
    type(By.name("group_name"), groupObject.getGroupName());
    type(By.name("group_header"), groupObject.getGroupHeader());
    type (By.name("group_footer"), groupObject.getGroupFooter());
  }

  public void goToNewGroup() {
    click (By.name("new"));
  }


  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
  }

  public void deleteGroup() {
    click (By.name("delete"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void initGroupModification() {
    click (By.name("edit"));
  }

  public void create(GroupObject groupObject) {
    goToNewGroup();
    fillGroupFields(groupObject);
    sumbitNewGroupCreation();
    groupCache=null;
    returnToGroupPage();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache!=null){
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements){
      String name  = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupObject group= new GroupObject().withId(id).withName(name);
      groupCache.add(group);
    }
    return new Groups(groupCache);
  }

  public void modify(GroupObject group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupFields(group);
    submitGroupModification();
    groupCache=null;
    returnToGroupPage();
  }

  public void delete(GroupObject group) {
    selectGroupById(group.getId());
    deleteGroup();
    groupCache=null;
    returnToGroupPage();
  }
}
