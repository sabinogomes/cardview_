package br.com.lordsabino.cardview.model.enums;

public enum TrapProperty {
    NORMAL("Normal"),
    CONTINUOUS("Continuous"),
    COUNTER("Counter");

    private final String description;

    TrapProperty(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
