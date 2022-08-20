package com.raidrin.flashcard.db.repos;

import com.raidrin.flashcard.db.entities.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
