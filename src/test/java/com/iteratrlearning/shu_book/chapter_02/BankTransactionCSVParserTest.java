package com.iteratrlearning.shu_book.chapter_02;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankTransactionCSVParserTest {

    private BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        String line = "30-01-2017,-50,Tesco";

        BankTransaction result = statementParser.parseFrom(line);

        BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }

    @Test
    public void shouldParseLineWithLargeAmount() throws Exception {
        final String line = "01-02-2017,1000000,Salary";
        final BankTransaction result = statementParser.parseFrom(line);

        // Verificamos que maneje números grandes correctamente
        Assert.assertEquals(1000000.0, result.getAmount(), 0.0d);
    }

    @Test(expected = java.time.format.DateTimeParseException.class)
    public void shouldFailWhenDateIsMalformed() throws Exception {
        // El formato esperado es dd-MM-yyyy
        final String line = "2017/01/30,100,Deliveroo";
        statementParser.parseFrom(line);
    }

    @Test(expected = NumberFormatException.class)
    public void shouldFailWhenAmountIsNotANumber() throws Exception {
        final String line = "30-01-2017,not_a_number,Tesco";
        statementParser.parseFrom(line);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldFailWhenDescriptionIsMissing() throws Exception {
        // Falta la tercera columna (descripción)
        final String line = "30-01-2017,100";
        statementParser.parseFrom(line);
    }
}