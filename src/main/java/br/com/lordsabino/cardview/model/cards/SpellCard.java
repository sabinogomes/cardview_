package br.com.lordsabino.cardview.model.cards;

import br.com.lordsabino.cardview.model.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "spell_cards")
public class SpellCard extends Card {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpellProperty property;

    protected SpellCard() {
    }

    public SpellCard(
            String name,
            String passcode,
            CardStatus status,
            String description,
            String imageUrl,
            SpellProperty property
    ) {
        super(name, passcode, status, description, imageUrl);

        update(property);
    }

    @Override
    public CardType getCardType() {
        return CardType.SPELL;
    }

    public final void update(SpellProperty property) {

        if (property == null) {
            throw new IllegalArgumentException("Spell property cannot be null");
        }

        this.property = property;
    }

    public SpellProperty getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return """
                SpellCard {
                    id=%s,
                    name='%s',
                    property=%s
                }
                """.formatted(
                getId(),
                getName(),
                property
        );
    }
}
