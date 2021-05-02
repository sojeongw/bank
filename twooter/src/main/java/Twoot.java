import java.util.Objects;

public class Twoot {
  private final String id;
  private final String senderId;
  private final String content;

  public Twoot(final String id, final String senderId, final String content) {
    Objects.requireNonNull(id, "id");
    Objects.requireNonNull(senderId, "senderId");
    Objects.requireNonNull(content, "content");

    this.id = id;
    this.senderId = senderId;
    this.content = content;
  }

  public String getId() {
    return id;
  }

  public String getSenderId() {
    return senderId;
  }

  public String getContent() {
    return content;
  }
}
