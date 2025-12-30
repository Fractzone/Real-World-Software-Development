package com.iteratrlearning.shu_book.chapter_05;

public class Main {

    public static void main(final String... args) {

        var env = new Facts();
        env.setFact("name", "Bob");
        env.setFact("jobTitle", "CEO");
        env.setFact("department", "Sales");

        final var businessRuleEngine = new BusinessRuleEngine(env);

        // Regla compleja con nombre, descripción, prioridad y múltiples condiciones
        final Rule ruleSalesCEO = RuleBuilder
                .when(facts -> "CEO".equals(facts.getFact("jobTitle")))
                .and(facts -> "Sales".equals(facts.getFact("department"))) // Segunda condición
                .withName("CEO Sales Alert")
                .withDescription("Avisa si el CEO de ventas está involucrado")
                .withPriority(10) // Alta prioridad
                .then(facts -> System.out.println("High Priority: Relevant customer (CEO of Sales): " + facts.getFact("name")));

        final Rule ruleRegular = RuleBuilder
                .when(facts -> true)
                .withPriority(1) // Baja prioridad
                .then(facts -> System.out.println("Low Priority: General check"));

        businessRuleEngine.addRule(ruleRegular);
        businessRuleEngine.addRule(ruleSalesCEO);

        businessRuleEngine.run(); // Debería imprimir primero "High Priority..." y luego "Low Priority..."
    }
}