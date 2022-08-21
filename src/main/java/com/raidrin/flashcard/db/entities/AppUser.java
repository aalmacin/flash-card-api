package com.raidrin.flashcard.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class AppUser {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    @OneToMany
    private Set<Card> cards;
}
