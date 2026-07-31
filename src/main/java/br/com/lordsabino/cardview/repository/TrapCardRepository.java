package br.com.lordsabino.cardview.repository;

import br.com.lordsabino.cardview.model.cards.TrapCard;
import br.com.lordsabino.cardview.model.enums.TrapProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrapCardRepository extends JpaRepository<TrapCard, Long> {

    Page<TrapCard> findByProperty(TrapProperty property, Pageable pageable);
}