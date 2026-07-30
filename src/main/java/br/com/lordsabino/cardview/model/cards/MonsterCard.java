package br.com.lordsabino.cardview.model.cards;

import br.com.lordsabino.cardview.model.enums.*;

import java.time.LocalDateTime;
import java.util.Set;

public class MonsterCard extends Card {

    private MonsterAttribute attribute;

    private MonsterRace monsterRace;

    private Set<MonsterType> monsterTypes;

    private Integer level;

    private Integer attack;

    private Integer defense;

    public MonsterCard() {
    }

    public MonsterCard(
            Long id,
            String name,
            MonsterAttribute attribute,
            MonsterRace monsterRace,
            Set<MonsterType> monsterTypes,
            Integer level,
            Integer attack,
            Integer defense,
            String passcode,
            CardStatus status,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        super(
                id,
                name,
                passcode,
                status,
                description,
                createdAt,
                updatedAt);
        this.attribute = attribute;
        this.monsterRace = monsterRace;
        this.monsterTypes = monsterTypes;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        String format = """
				ID: %s
				Name: %s
				Attribute: %s
				Race: %s
				Types: %s
				Level: %s
				Attack: %s
				Defense: %s
				passcode: %s
				Status: %s
				Description: %s
				Created At: %s
				Updated At: %s
				""";
        return String
                .format(
                        format,
                        getId(),
                        getName(),
                        attribute,
                        monsterRace,
                        monsterTypes,
                        level,
                        attack,
                        defense,
                        getPasscode(),
                        getStatus(),
                        getDescription(),
                        getCreatedAt(),
                        getUpdatedAt()
                );
    }

    @Override
    public CardType getCardType() {
        return CardType.MONSTER;
    }

    public MonsterAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(MonsterAttribute attribute) {
        this.attribute = attribute;
    }

    public MonsterRace getMonsterRace() {
        return monsterRace;
    }

    public void setMonsterRace(MonsterRace monsterRace) {
        this.monsterRace = monsterRace;
    }

    public Set<MonsterType> getMonsterTypes() {
        return monsterTypes;
    }

    public void setMonsterTypes(Set<MonsterType> monsterTypes) {
        this.monsterTypes = monsterTypes;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

}
