import java.util.Objects;

public class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;

    if(x != point.getX()) return false;

    return y == point.getY();
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;

    return result;
  }
}
