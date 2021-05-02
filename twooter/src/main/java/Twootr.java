import java.util.Optional;

public class Twootr {

  public Optional<SenderEndPoint> onLogon(String userId, final String password, ReceiverEndPoint receiver) {
    return null;
  }

  FollowStatus onFollow(final User follow, final String userIdToFollow) {
    return null;
  }

   void onSendTwoot(final String id, final User user, final String content) {
    final String userId = user.getId();
    final Twoot twoot = new Twoot(id, userId, content, new Position());

    user.followers()
        .filter(User::isLoggedOn)
        .forEach(follower -> follower.receiveTwoot(twoot));
  }
}
