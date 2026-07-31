package br.com.lordsabino.cardview.repository;

import br.com.lordsabino.cardview.model.cards.Card;
import br.com.lordsabino.cardview.model.enums.CardType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByPasscode(String passcode);

    boolean existsByPasscode(String passcode);

    Page<Card> findByCardType(CardType cardType, Pageable pageable);

    Page<Card> findByNameContainingIgnoreCase(String name, Pageable pageable);
}