package com.demo.bankstatementanalyzer;

public interface Exporter {
  String export(SummaryStatistics summaryStatistics);
}
