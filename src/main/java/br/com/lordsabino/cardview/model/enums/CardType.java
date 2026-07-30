package br.com.lordsabino.cardview.model.enums;

public enum CardType {
    MONSTER("Monster"),
    SPELL("Spell"),
    TRAP("Trap");

    private final String description;

    CardType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
