package br.com.lordsabino.cardview.model.cards;

import br.com.lordsabino.cardview.model.base.BaseEntity;
import br.com.lordsabino.cardview.model.enums.CardStatus;
import br.com.lordsabino.cardview.model.enums.CardType;

import java.time.LocalDateTime;


public abstract class Card extends BaseEntity {

    private String name;

    private String passcode;

    private CardStatus status;

    private String description;

    public Card() {
    }

    public Card(
            Long id,
            String name,
            String passcode,
            CardStatus status,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        super(
                id,
                createdAt,
                updatedAt
        );
        this.name = name;
        this.passcode = passcode;
        this.status = status;
        this.description = description;
    }

    public abstract CardType getCardType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
