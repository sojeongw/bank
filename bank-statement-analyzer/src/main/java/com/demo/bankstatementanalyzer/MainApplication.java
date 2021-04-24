package com.demo.bankstatementanalyzer;

import java.io.IOException;

public class MainApplication {

  public static void main(String[] args) throws IOException {
    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
    final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

    bankStatementAnalyzer.analyze(args[0], bankStatementCSVParser);
  }
}
