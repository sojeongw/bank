import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class BusinessRuleEngineTest {

  @Test
  void shouldHaveNoRulesInitially() {
    final Facts mockFacts = mock(Facts.class);
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

    assertEquals(0, businessRuleEngine.count());
  }

  @Test
  void shouldAddTwoActions() {
    final Facts mockFacts = mock(Facts.class);
    final Action mockAction = mock(Action.class);
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

    businessRuleEngine.addAction(mockAction);
    businessRuleEngine.addAction(mockAction);

    assertEquals(2, businessRuleEngine.count());
  }

  @Test
  void shouldExecuteOneAction() {
    // given
    final Facts mockFacts = mock(Facts.class);
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);
    final Action mockAction = mock(Action.class);

    businessRuleEngine.addAction(mockAction);

    // when
    businessRuleEngine.run();

    // then
    verify(mockAction).execute(mockFacts);
  }

  @Test
  void shouldPerformAnActionWithAnonymousClass() {
    final Facts mockFacts = mock(Facts.class);
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

    businessRuleEngine.addAction(new Action() {
      @Override
      public void execute(final Facts facts) {
        var jobTitle = facts.getFact("jobTitle");

        if("CEO".equals(jobTitle)) {
          var name = facts.getFact("name");
          Mailer.sendEmail("sales@company.com", "Relevant customer: " + name);
        }
      }
    });
  }

  @Test
  void shouldPerformAnActionWithLambda() {
    final Facts mockFacts = mock(Facts.class);
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

    businessRuleEngine.addAction(facts -> {
     var forecastedAmount = 0.0;
     var dealStage = Stage.valueOf(facts.getFact("stage"));
     var amount = Double.parseDouble(facts.getFact("amount"));

     if(dealStage == Stage.LEAD) {
       forecastedAmount = amount * 0.2;
     } else if (dealStage == Stage.EVALUATING) {
       forecastedAmount = amount * 0.5;
     } else if(dealStage == Stage.INTERESTED) {
       forecastedAmount = amount * 0.8;
     } else if(dealStage == Stage.CLOSED) {
       forecastedAmount = amount;
     }

     facts.addFact("forecastedAmount", String.valueOf(forecastedAmount));
    });
  }

  @Test
  void shouldPerformAnActionWithFacts() {
    final Action mockAction = mock(Action.class);
    final Facts mockFacts = mock(Facts.class);
    final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);

    businessRuleEngine.addAction(mockAction);
    businessRuleEngine.run();

    verify(mockAction).execute(mockFacts);
  }
}