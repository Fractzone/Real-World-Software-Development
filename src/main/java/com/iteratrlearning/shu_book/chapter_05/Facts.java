package com.iteratrlearning.shu_book.chapter_05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facts {

    private final Map<String, String> facts = new HashMap<>();

    public String getFact(String name) {
        return this.facts.get(name);
    }

    public void setFact(String name, String value) {
        this.facts.put(name, value);
    }

    // --- NUEVO METODO ---
    public void loadFromJsonFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            line = line.trim();
            // Ignoramos llaves de inicio/fin de JSON simple
            if (line.equals("{") || line.equals("}")) continue;

            // Limpiamos comillas y comas finales
            String cleanLine = line.replace("\"", "").replace(",", "");

            String[] parts = cleanLine.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                this.setFact(key, value);
            }
        }
    }
}