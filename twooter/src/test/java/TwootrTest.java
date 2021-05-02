import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class TwootrTest {

  // mockReceiverEndPoint
  private final ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);

  private Twootr twootr;
  private SenderEndPoint endPoint;

  @Test
  public void shouldBeAbleToAuthenticateUser() {
    // 유효 사용자의 로그온 메시지 수신

    // 로그온 메서드는 새 엔드포인트 반환

    // 엔드포인트 유효성을 확인하는 어서션
  }

  @Test
  public void shouldNotAuthenticateUserWithWrongPassword() {
    final Optional<SenderEndPoint> endPoint = twootr
        .onLogon(TestData.USER_ID, "bad password", receiverEndPoint);

    assertFalse(endPoint.isPresent());
  }

  @Test
  void shouldFollowValidUser() {
    logon();
    final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);
    assertEquals(FollowStatus.SUCCESS, followStatus);
  }

  @Test
  void shouldNotDuplicateFollowValidUser() {
    logon();

    endPoint.onFollow(TestData.OTHER_USER_ID);

    final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);

    assertEquals(FollowStatus.ALREADY_FOLLOWING, followStatus);
  }

  @Test
  void verifyReceiverEndPoint() {
    Twoot twoot = new Twoot("id", "sender-id", "content", new Position());

    verify(receiverEndPoint).onTwoot(twoot);
  }

  private void logon() {
    this.endPoint = logon(TestData.USER_ID, receiverEndPoint);
  }

  private SenderEndPoint logon(final String userId, final ReceiverEndPoint receiverEndPoint) {
    final Optional<SenderEndPoint> endPoint = twootr
        .onLogon(userId, TestData.PASSWORD, receiverEndPoint);
    assertTrue(endPoint.isPresent(), "Failed to logon");
    return endPoint.get();
  }
}
