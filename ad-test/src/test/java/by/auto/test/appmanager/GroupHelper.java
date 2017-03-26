package by.auto.test.appmanager;

import by.auto.test.model.GroupObject;
import com.sun.javafx.image.BytePixelSetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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


  public void selectGroup() {
    click(By.name("selected[]"));
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

  public void createGroup(GroupObject groupObject) {
    goToNewGroup();
    fillGroupFields(groupObject);
    sumbitNewGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereGroup() {
      return isElementPresent(By.name("selected[]"));
    }

  public boolean isThereGroupByGroupName(String groupName) {
    return (wd.findElement(By.xpath("//div[@id='content']//span")).getText().equals(groupName));
  }
}
