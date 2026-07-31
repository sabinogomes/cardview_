package br.com.lordsabino.cardview.repository;

import br.com.lordsabino.cardview.model.cards.SpellCard;
import br.com.lordsabino.cardview.model.enums.SpellProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellCardRepository extends JpaRepository<SpellCard, Long> {

    Page<SpellCard> findByProperty(SpellProperty property, Pageable pageable);
}