import java.util.Objects;

public class Position {
/**
 * 최근 확인한 트웃의 위치
 */

  public static final Position INITIAL_POSITION = new Position(-1);

  private final int value;

  private Position(final int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public Position next() {
    return new Position(value + 1);
  }

  @Override
  public String toString() {
    return "Position{" +
        "value=" + value +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return getValue() == position.getValue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }
}
