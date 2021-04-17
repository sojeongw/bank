package com.demo.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankStatementCSVParserTest {

  private final BankStatementParser statementParser = new BankStatementCSVParser();

  @Test
  public void shouldParseOneCorrectLine() throws Exception {
    final String line = "30-01-2017,-50,Tesco";
    final BankTransaction result = statementParser.parseFrom(line);

    final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

    Assertions.assertEquals(expected.getDate(), result.getDate());
    Assertions.assertEquals(expected.getAmount(), result.getAmount());
    Assertions.assertEquals(expected.getDescription(), result.getDescription());
  }

}