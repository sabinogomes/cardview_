package br.com.lordsabino.cardview.model.enums;

public enum MonsterAttribute {
    DARK("Dark"),
    LIGHT("Light"),
    EARTH("Earth"),
    WATER("Water"),
    FIRE("Fire"),
    WIND("Wind"),
    DIVINE("Divine");

    private final String description;

    MonsterAttribute(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
