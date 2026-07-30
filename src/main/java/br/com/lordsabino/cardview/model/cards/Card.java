package br.com.lordsabino.cardview.model.cards;

import br.com.lordsabino.cardview.model.base.BaseEntity;
import br.com.lordsabino.cardview.model.enums.CardStatus;
import br.com.lordsabino.cardview.model.enums.CardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cards")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "card_type")
public abstract class Card extends BaseEntity {

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String passcode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardStatus status;

    @Size(max = 4000)
    @Column(length = 4000)
    private String description;

    @Size(max = 500)
    @Column(length = 500)
    private String imageUrl;

    protected Card() {
    }

    protected Card(
            String name,
            String passcode,
            CardStatus status,
            String description,
            String imageUrl
    ) {

        update(
                name,
                passcode,
                status,
                description,
                imageUrl
        );
    }

    public abstract CardType getCardType();

    /**
     * Atualiza os dados comuns da carta.
     * Usado na criação e na edição da carta.
     */
    public void update(
            String name,
            String passcode,
            CardStatus status,
            String description,
            String imageUrl
    ) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (passcode == null || passcode.isBlank()) {
            throw new IllegalArgumentException("Passcode cannot be blank");
        }

        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }

        this.name = name;
        this.passcode = passcode;
        this.status = status;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getPasscode() {
        return passcode;
    }

    public CardStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
