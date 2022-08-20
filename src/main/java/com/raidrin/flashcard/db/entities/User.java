package com.raidrin.flashcard.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    private int ID;
    private String name;
    private String email;
    private String password;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private Card[] cards;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private Review[] reviews;
}
