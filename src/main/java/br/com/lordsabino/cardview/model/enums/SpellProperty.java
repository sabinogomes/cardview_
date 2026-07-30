package br.com.lordsabino.cardview.model.enums;

public enum SpellProperty {
    NORMAL("Normal"),
    QUICK_PLAY("Quick-Play"),
    CONTINUOUS("Continuous"),
    EQUIP("Equip"),
    FIELD("Field"),
    RITUAL("Ritual");

    private final String description;

    SpellProperty(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
