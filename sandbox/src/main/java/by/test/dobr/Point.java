package by.test.dobr;

public class Point {
  public double x;
  public double y;
  public Point(double x, double y){
    this.x=x;
    this.y=y;
  }

  public double distance() {
    Point a = new Point(4,8);
    Point b = new Point(5,10);
    double result = Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    return result;
  }
}
