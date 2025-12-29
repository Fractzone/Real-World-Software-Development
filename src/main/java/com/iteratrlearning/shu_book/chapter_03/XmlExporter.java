package com.iteratrlearning.shu_book.chapter_03;

public class XmlExporter implements Exporter {
    @Override
    public String export(final SummaryStatistics summaryStatistics) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<summary>\n" +
                "    <sum>" + summaryStatistics.getSum() + "</sum>\n" +
                "    <average>" + summaryStatistics.getAverage() + "</average>\n" +
                "    <max>" + summaryStatistics.getMax() + "</max>\n" +
                "    <min>" + summaryStatistics.getMin() + "</min>\n" +
                "</summary>";
    }
}