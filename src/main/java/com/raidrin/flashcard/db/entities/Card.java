package com.raidrin.flashcard.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Card {
    @Id
    private int ID;
    private String front;
    private String back;
    private boolean reversible;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private User user;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private Review[] reviews;
}
