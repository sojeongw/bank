package com.demo.bank;

import java.time.Month;
import java.util.List;

interface CalculateTotalAmount {

  double calculateTotalAmount();
}

interface CalculateAverage {

  double calculateAverage();
}

interface CalculateTotalInMonth {

  double calculateTotalInMonth(Month month);
}