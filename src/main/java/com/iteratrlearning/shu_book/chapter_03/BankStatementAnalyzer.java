package com.iteratrlearning.shu_book.chapter_03;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public String analyze(final String fileName,
                        final BankStatementParser bankStatementParser,
                        final Exporter exporter) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();

        //System.out.println(exporter.export(summaryStatistics));
        return exporter.export(summaryStatistics);

    }

    // Nuevo metodo para retornar el string en lugar de solo imprimirlo
    public String analyzeWithReturn(final String fileName,
                                    final BankStatementParser bankStatementParser,
                                    final Exporter exporter) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();

        return exporter.export(summaryStatistics);
    }
}
