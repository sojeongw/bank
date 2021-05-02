import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class BusinessRuleEngineTest {

  @Test
  void shouldHaveNoRulesInitially() {
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

    assertEquals(0, businessRuleEngine.count());
  }

  @Test
  void shouldAddTwoActions() {
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

    businessRuleEngine.addAction(() -> {});
    businessRuleEngine.addAction(() -> {});

    assertEquals(2, businessRuleEngine.count());
  }

  @Test
  void shouldExecuteOneAction() {
    // given
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
    final Action mockAction = mock(Action.class);

    businessRuleEngine.addAction(mockAction);

    // when
    businessRuleEngine.run();

    // then
    verify(mockAction).execute();
  }
}