package br.com.lordsabino.cardview.model.enums;

public enum MonsterType {
    NORMAL("Normal"),
    EFFECT("Effect"),
    FUSION("Fusion"),
    RITUAL("Ritual"),
    SYNCHRO("Synchro"),
    XYZ("Xyz"),
    PENDULUM("Pendulum"),
    LINK("Link"),
    TOKEN("Token");

    private final String description;

    MonsterType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
