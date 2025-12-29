package com.iteratrlearning.shu_book.chapter_02;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {

                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public BankTransaction findHighestTransactionInDateRange(final LocalDate start, final LocalDate end) {
        return bankTransactions.stream()
                .filter(t -> !t.getDate().isBefore(start) && !t.getDate().isAfter(end))
                .max((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()))
                .orElse(null);
    }

    public BankTransaction findLowestTransactionInDateRange(final LocalDate start, final LocalDate end) {
        return bankTransactions.stream()
                .filter(t -> !t.getDate().isBefore(start) && !t.getDate().isAfter(end))
                .min((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()))
                .orElse(null);
    }

    // Histograma de gastos por Mes
    public Map<Month, Double> summarizeTransactionsByMonth() {
        return bankTransactions.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getDate().getMonth(),
                        Collectors.summingDouble(BankTransaction::getAmount)
                ));
    }

    // Histograma de gastos por Descripción
    public Map<String, Double> summarizeTransactionsByDescription() {
        return bankTransactions.stream()
                .collect(Collectors.groupingBy(
                        BankTransaction::getDescription,
                        Collectors.summingDouble(BankTransaction::getAmount)
                ));
    }
}
