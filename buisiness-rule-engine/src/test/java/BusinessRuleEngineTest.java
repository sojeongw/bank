import java.util.Optional;
import org.junit.jupiter.api.Test;

class BusinessRuleEngineTest {

  @Test
  void shouldPerformAnActionWithBuilder() {
    final Rule ruleSendEmailToSalesWhenCEO = RuleBuilder
        .when(facts -> "CEO".equals(facts.getFact("jobTitle")))
        .then(facts -> {
          var name = facts.getFact("name");
          Mailer.sendEmail("sales@company.com", "Relevant customer: " + name);
        });
  }
  @Test
  void testOptional() {
    Optional<String> a = Optional.of("abc");
    System.out.println(a);
    System.out.println(a.get());

    Optional emptyOptional = Optional.empty();
    System.out.println(emptyOptional);
    System.out.println(emptyOptional.get());

    Optional alsoEmpty = Optional.ofNullable(null);
    System.out.println(alsoEmpty);
    System.out.println(alsoEmpty.get());
  }
}