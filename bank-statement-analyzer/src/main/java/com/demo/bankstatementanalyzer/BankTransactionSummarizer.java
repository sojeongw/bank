package com.demo.bankstatementanalyzer;

@FunctionalInterface
public interface BankTransactionSummarizer {
  double summarize(double accumulator, BankTransaction bankTransaction);
}
