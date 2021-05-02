import java.util.Optional;

public class Twootr {

  public Optional<SenderEndPoint> onLogon(String userId, final String password, ReceiverEndPoint receiver) {
    return null;
  }

  FollowStatus onFollow(final User follow, final String userIdToFollow) {
    return null;
  }
}
