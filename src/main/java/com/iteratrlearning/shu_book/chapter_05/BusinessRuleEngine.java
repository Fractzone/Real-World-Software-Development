package com.iteratrlearning.shu_book.chapter_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusinessRuleEngine {

    private final List<Rule> rules;
    private final Facts facts;

    public BusinessRuleEngine(Facts facts) {
        this.facts = facts;
        this.rules = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void run() {
        // Ordenar reglas por prioridad antes de ejecutar
        Collections.sort(rules);
        this.rules.forEach(rule -> rule.perform(facts));
    }

    // Metodo auxiliar para obtener el conteo de reglas (útil para tests)
    public int countRules() {
        return rules.size();
    }
}