package com.iteratrlearning.shu_book.chapter_05;

public class Rule implements Comparable<Rule> {

    private final String name;
    private final String description;
    private final int priority; // Mayor número = mayor prioridad
    private final Condition condition;
    private final Action action;

    public Rule(final String name,
                final String description,
                final int priority,
                final Condition condition,
                final Action action) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.condition = condition;
        this.action = action;
    }

    public void perform(Facts facts) {
        if (condition.evaluate(facts)) {
            action.execute(facts);
        }
    }

    @Override
    public int compareTo(Rule otherRule) {
        // Orden descendente (Mayor prioridad primero)
        return Integer.compare(otherRule.priority, this.priority);
    }

    // Getters opcionales si los necesitas para tests
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
}