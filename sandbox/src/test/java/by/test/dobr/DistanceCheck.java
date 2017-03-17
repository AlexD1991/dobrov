package by.test.dobr;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by AlexD on 3/17/2017.
 */
public class DistanceCheck {
  @Test
  public void distanceTest(){
    Point p1 = new Point(1,5);
    Point p2 = new Point(2,5);
    Assert.assertEquals(p1.distance(p2),1.0);
  }

}
