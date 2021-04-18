package com.demo.bank;

@FunctionalInterface
public interface BankTransactionSummarizer {
  double summarize(double accumulator, BankTransaction bankTransaction);
}
