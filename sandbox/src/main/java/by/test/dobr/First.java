package by.test.dobr;

public class First {
  public static double distance(Point p1, Point p2) {
    double result = Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    return result;
  }

  public static void main(String[] args) {
    System.out.println("Hi, world!");
    Point first = new Point(5, 6);
    Point second = new Point(5, 10);
    System.out.println("Distance between p1(" + first.x + "," + first.y + ") and p2(" + second.x + "," + second.y + ") = " + distance(first, second));
    System.out.println("Distance between p1(" + first.x + "," + first.y + ") and p2(" + second.x + "," + second.y + ") = " + first.distance(second));
  }

}