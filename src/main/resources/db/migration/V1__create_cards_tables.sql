-- Tabela pai: campos comuns a toda carta (Card).
-- Estrategia de heranca JOINED: cada subtipo tem sua propria tabela,
-- ligada a "cards" por chave estrangeira (id compartilhado).
CREATE TABLE cards (
                       id           BIGSERIAL PRIMARY KEY,
                       card_type    VARCHAR(31)   NOT NULL,
                       name         VARCHAR(255)  NOT NULL,
                       passcode     VARCHAR(8)    NOT NULL,
                       status       VARCHAR(255)  NOT NULL,
                       description  VARCHAR(4000),
                       image_url    VARCHAR(500),
                       created_at   TIMESTAMP     NOT NULL,
                       updated_at   TIMESTAMP     NOT NULL,

                       CONSTRAINT uq_cards_passcode UNIQUE (passcode)
);

COMMENT ON TABLE cards IS 'Tabela pai da hierarquia de cartas (Monster, Spell, Trap)';
COMMENT ON COLUMN cards.card_type IS 'Discriminador da subclasse concreta (MONSTER, SPELL, TRAP)';

-- Subtipo: MonsterCard
CREATE TABLE monster_cards (
                               id        BIGINT PRIMARY KEY,
                               attribute VARCHAR(255) NOT NULL,
                               race      VARCHAR(255) NOT NULL,
                               level     INTEGER      NOT NULL,
                               attack    INTEGER      NOT NULL,
                               defense   INTEGER      NOT NULL,

                               CONSTRAINT fk_monster_cards_card FOREIGN KEY (id) REFERENCES cards (id),
                               CONSTRAINT ck_monster_cards_level CHECK (level BETWEEN 1 AND 12),
                               CONSTRAINT ck_monster_cards_attack CHECK (attack >= 0),
                               CONSTRAINT ck_monster_cards_defense CHECK (defense >= 0)
);

-- Colecao de tipos do monstro (Set<MonsterType> via @ElementCollection)
CREATE TABLE monster_card_types (
                                    monster_card_id BIGINT       NOT NULL,
                                    monster_type    VARCHAR(255) NOT NULL,

                                    CONSTRAINT fk_monster_card_types_monster_card
                                        FOREIGN KEY (monster_card_id) REFERENCES monster_cards (id),
                                    CONSTRAINT uq_monster_card_types UNIQUE (monster_card_id, monster_type)
);

-- Subtipo: SpellCard
CREATE TABLE spell_cards (
                             id       BIGINT PRIMARY KEY,
                             property VARCHAR(255) NOT NULL,

                             CONSTRAINT fk_spell_cards_card FOREIGN KEY (id) REFERENCES cards (id)
);

-- Subtipo: TrapCard
CREATE TABLE trap_cards (
                            id       BIGINT PRIMARY KEY,
                            property VARCHAR(255) NOT NULL,

                            CONSTRAINT fk_trap_cards_card FOREIGN KEY (id) REFERENCES cards (id)
);

-- Indices de apoio a consultas mais comuns
CREATE INDEX idx_cards_card_type ON cards (card_type);
CREATE INDEX idx_cards_name ON cards (name);