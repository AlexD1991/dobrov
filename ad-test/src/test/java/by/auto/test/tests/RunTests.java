package by.auto.test.tests;

import by.auto.test.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.auto.test.model.GroupObject;

/**
 * Created by AlexD on 3/25/2017.
 */
public class RunTests extends TestBase{
@Test
public void testContactCreation1(){
   GroupCreation test = new GroupCreation();
   test.testGroupCreation();
}
}
