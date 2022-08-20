package com.raidrin.flashcard.db.repos;

import com.raidrin.flashcard.db.entities.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
}
