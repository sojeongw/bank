package com.demo.bankstatementanalyzer;

import java.util.List;

public interface BankStatementParser {
  BankTransaction parseFrom(String line);
  List<BankTransaction> parseLinesFrom(List<String> lines);
}
