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

  public boolean validate() {
    if (this.description.length() > 100) {
      throw new IllegalArgumentException("The description is too long");
    }

    final LocalDate parsedDate;

    try {
      parsedDate = LocalDate.parse(this.date);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid format for date", e);
    }

    if (parsedDate.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("Date cannot be in the future");
    }

    try {
      Double.parseDouble(this.amount);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid format for amount", e);
    }

    return true;
  }
}
