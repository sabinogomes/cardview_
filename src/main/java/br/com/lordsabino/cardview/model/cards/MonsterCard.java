package br.com.lordsabino.cardview.model.cards;

import br.com.lordsabino.cardview.model.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monster_cards")
public class MonsterCard extends Card {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonsterAttribute attribute;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonsterRace race;

    @NotEmpty(message = "Monster must have at least one type")
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "monster_card_types",
            joinColumns = @JoinColumn(name = "monster_card_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "monster_type", nullable = false)
    private final Set<MonsterType> monsterTypes = new HashSet<>();

    @NotNull
    @Min(1)
    @Max(12)
    @Column(nullable = false)
    private Integer level;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer attack;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer defense;

    protected MonsterCard() {
    }

    public MonsterCard(
            String name,
            String passcode,
            CardStatus status,
            String description,
            String imageUrl,
            MonsterAttribute attribute,
            MonsterRace race,
            Set<MonsterType> monsterTypes,
            Integer level,
            Integer attack,
            Integer defense
    ) {
        super(name, passcode, status, description, imageUrl);

        update(
                attribute,
                race,
                monsterTypes,
                level,
                attack,
                defense
        );
    }

    @Override
    public CardType getCardType() {
        return CardType.MONSTER;
    }

    public void update(
            MonsterAttribute attribute,
            MonsterRace race,
            Set<MonsterType> monsterTypes,
            Integer level,
            Integer attack,
            Integer defense
    ) {

        if (attribute == null) {
            throw new IllegalArgumentException("Monster attribute cannot be null");
        }

        if (race == null) {
            throw new IllegalArgumentException("Monster race cannot be null");
        }

        if (monsterTypes == null || monsterTypes.isEmpty()) {
            throw new IllegalArgumentException("Monster must have at least one type");
        }

        if (level == null || level < 1 || level > 12) {
            throw new IllegalArgumentException("Level must be between 1 and 12");
        }

        if (attack == null || attack < 0) {
            throw new IllegalArgumentException("Attack must be greater than or equal to zero");
        }

        if (defense == null || defense < 0) {
            throw new IllegalArgumentException("Defense must be greater than or equal to zero");
        }

        this.attribute = attribute;
        this.race = race;
        this.level = level;
        this.attack = attack;
        this.defense = defense;

        this.monsterTypes.clear();
        this.monsterTypes.addAll(monsterTypes);
    }

    public MonsterAttribute getAttribute() {
        return attribute;
    }

    public MonsterRace getRace() {
        return race;
    }

    public Set<MonsterType> getMonsterTypes() {
        return Collections.unmodifiableSet(monsterTypes);
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return """
                MonsterCard {
                    id=%s,
                    name='%s',
                    attribute=%s,
                    race=%s,
                    types=%s,
                    level=%s,
                    attack=%s,
                    defense=%s
                }
                """.formatted(
                getId(),
                getName(),
                attribute,
                race,
                monsterTypes,
                level,
                attack,
                defense
        );
    }
}
