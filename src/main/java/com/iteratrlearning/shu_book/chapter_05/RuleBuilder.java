package com.iteratrlearning.shu_book.chapter_05;

public class RuleBuilder {
    private final Condition condition;
    // Valores por defecto
    private String name = "Unknown Rule";
    private String description = "No description";
    private int priority = 0;

    private RuleBuilder(Condition condition) {
        this.condition = condition;
    }

    public static RuleBuilder when(Condition condition) {
        return new RuleBuilder(condition);
    }

    // Permite encadenar condiciones: .when(c1).and(c2)
    public RuleBuilder and(Condition extraCondition) {
        return new RuleBuilder(this.condition.and(extraCondition));
    }

    public RuleBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RuleBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public RuleBuilder withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public Rule then(Action action) {
        return new Rule(name, description, priority, condition, action);
    }
}