package com.raidrin.flashcard.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Card {
    @Id
    private int id;
    private String front;
    private String back;
    private boolean reversible;
    @OneToMany
    private Set<Review> reviews;
    @ManyToOne
    private AppUser appUser;
}
