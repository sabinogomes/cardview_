package br.com.lordsabino.cardview.repository;

import br.com.lordsabino.cardview.model.cards.MonsterCard;
import br.com.lordsabino.cardview.model.enums.MonsterAttribute;
import br.com.lordsabino.cardview.model.enums.MonsterRace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterCardRepository extends JpaRepository<MonsterCard, Long> {

    Page<MonsterCard> findByAttribute(MonsterAttribute attribute, Pageable pageable);

    Page<MonsterCard> findByRace(MonsterRace race, Pageable pageable);

    Page<MonsterCard> findByLevel(Integer level, Pageable pageable);

    Page<MonsterCard> findByAttackGreaterThanEqual(Integer attack, Pageable pageable);
}