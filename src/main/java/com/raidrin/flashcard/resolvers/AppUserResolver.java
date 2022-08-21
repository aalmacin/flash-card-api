package com.raidrin.flashcard.resolvers;

import com.raidrin.flashcard.db.entities.AppUser;
import com.raidrin.flashcard.db.repos.UserRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserResolver {
    @Autowired
    private UserRepository userRepository;

    public DataFetcher<List<AppUser>> findAllUsers() {
        return data -> (List<AppUser>) userRepository.findAll();
    }
}
