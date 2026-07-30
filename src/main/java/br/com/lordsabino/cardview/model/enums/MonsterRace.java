package br.com.lordsabino.cardview.model.enums;

public enum MonsterRace {
    SPELLCASTER("Spellcaster"),
    WARRIOR("Warrior"),
    DRAGON("Dragon"),
    FIEND("Fiend"),
    FAIRY("Fairy"),
    BEAST("Beast"),
    BEAST_WARRIOR("Beast-Warrior"),
    WINGED_BEAST("Winged Beast"),
    ZOMBIE("Zombie"),
    MACHINE("Machine"),
    ROCK("Rock"),
    PYRO("Pyro"),
    AQUA("Aqua"),
    FISH("Fish"),
    SEA_SERPENT("Sea Serpent"),
    REPTILE("Reptile"),
    DINOSAUR("Dinosaur"),
    INSECT("Insect"),
    PLANT("Plant"),
    THUNDER("Thunder"),
    DIVINE_BEAST("Divine-Beast"),
    WYRM("Wyrm"),
    CYBERSE("Cyberse"),
    PSYCHIC("Psychic"),
    ILLUSION("Illusion");

    private final String description;

    MonsterRace(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
