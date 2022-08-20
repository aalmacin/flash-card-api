package com.raidrin.flashcard.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Review {
    @Id
    private int ID;
    private long timestamp;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private User user;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private Card card;
}
