package com.iteratrlearning.shu_book.chapter_03;

import javax.swing.*;
import java.awt.*;

public class BankAnalyzerGUI extends JFrame {

    private final JTextArea reportArea = new JTextArea();

    public BankAnalyzerGUI() {
        super("Analizador Bancario - Real World Software Development");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Botones para elegir formato
        JPanel panel = new JPanel();
        JButton btnHtml = new JButton("Ver HTML");
        JButton btnJson = new JButton("Ver JSON");

        panel.add(btnHtml);
        panel.add(btnJson);

        add(new JScrollPane(reportArea), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Lógica de los botones
        btnHtml.addActionListener(e -> mostrarReporte(new HtmlExporter()));
        btnJson.addActionListener(e -> mostrarReporte(new JsonExporter()));
    }

    private void mostrarReporte(Exporter exporter) {
        try {
            BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
            // Necesitaremos que analyze devuelva un String o usar una variable temporal
            // Por ahora, para probar, usaremos un texto de ejemplo:
            reportArea.setText("Generando reporte en formato: " + exporter.getClass().getSimpleName());

            // Aquí llamarías a tu lógica:
            // String resultado = analyzer.analyze("bank-data-simple.csv", new BankStatementCSVParser(), exporter);
            // reportArea.setText(resultado);
        } catch (Exception ex) {
            reportArea.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankAnalyzerGUI().setVisible(true));
    }
}