package com.raidrin.flashcard.resolvers;

import com.raidrin.flashcard.db.entities.Card;
import com.raidrin.flashcard.db.repos.CardRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardResolver {
    @Autowired
    private CardRepository cardRepository;

    public DataFetcher<List<Card>> findAllCards() {
        return data -> (List<Card>) cardRepository.findAll();
    }
}
