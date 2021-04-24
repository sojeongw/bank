package com.demo.bank;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class OverlySpecificBankStatementValidator {

  private String description;
  private String date;
  private String amount;

  public OverlySpecificBankStatementValidator(String description, String date,
      String amount) {
    this.description = description;
    this.date = date;
    this.amount = amount;
  }

  public boolean validate()
      throws DescriptionTooLongException, InvalidDateFormat, DateInTheFutureException, InvalidAmountException {
    if (this.description.length() > 100) {
      throw new DescriptionTooLongException();
    }

    final LocalDate parsedDate;

    try {
      parsedDate = LocalDate.parse(this.date);
    } catch (DateTimeParseException e) {
      throw new InvalidDateFormat();
    }

    if (parsedDate.isAfter(LocalDate.now())) {
      throw new DateInTheFutureException();
    }

    try {
      Double.parseDouble(this.amount);
    } catch (NumberFormatException e) {
      throw new InvalidDateFormat();
    }

    return true;
  }
}
