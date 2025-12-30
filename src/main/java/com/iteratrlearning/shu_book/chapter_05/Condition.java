package com.iteratrlearning.shu_book.chapter_05;

@FunctionalInterface
public interface Condition {

    boolean evaluate(Facts facts);

    // Nuevo metodo para encadenar condiciones (AND lógico)
    default Condition and(Condition other) {
        return facts -> this.evaluate(facts) && other.evaluate(facts);
    }
}
