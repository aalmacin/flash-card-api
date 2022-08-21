package com.raidrin.flashcard.db.repos;

import com.raidrin.flashcard.db.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Integer> {
}
