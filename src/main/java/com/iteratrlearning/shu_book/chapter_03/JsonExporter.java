package com.iteratrlearning.shu_book.chapter_03;

public class JsonExporter implements Exporter {
    @Override
    public String export(final SummaryStatistics summaryStatistics) {
        return "{\n" +
                "  \"sum\": " + summaryStatistics.getSum() + ",\n" +
                "  \"average\": " + summaryStatistics.getAverage() + ",\n" +
                "  \"max\": " + summaryStatistics.getMax() + ",\n" +
                "  \"min\": " + summaryStatistics.getMin() + "\n" +
                "}";
    }
}