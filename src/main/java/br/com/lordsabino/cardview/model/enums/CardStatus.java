package br.com.lordsabino.cardview.model.enums;

public enum CardStatus {
    UNLIMITED("Unlimited"),
    LIMITED("Limited"),
    SEMI_LIMITED("Semi-Limited"),
    FORBIDDEN("Forbidden");

    private final String description;

    CardStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
