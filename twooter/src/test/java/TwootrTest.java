import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class TwootrTest {

  private final ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);

  @Test
  public void shouldBeAbleToAuthenticateUser() {
    // 유효 사용자의 로그온 메시지 수신

    // 로그온 메서드는 새 엔드포인트 반환

    // 엔드포인트 유효성을 확인하는 어서션
  }

  @Test
  public void shouldNotAuthenticateUserWithWrongPassword() {
    final Twootr twootr = new Twootr();
    final Optional<SenderEndPoint> endPoint = twootr.onLogon(TestData.USER_ID, "bad password", receiverEndPoint);

    assertFalse(endPoint.isPresent());
  }
}
