import java.util.Objects;

public class Twoot {
  private final String id;
  private final String senderId;
  private final String content;
  private final Position position;

  public Twoot(final String id, final String senderId, final String content, final Position position) {
    Objects.requireNonNull(id, "id");
    Objects.requireNonNull(senderId, "senderId");
    Objects.requireNonNull(content, "content");
    Objects.requireNonNull(position, "position");

    this.id = id;
    this.position = position;
    this.senderId = senderId;
    this.content = content;
  }
}
