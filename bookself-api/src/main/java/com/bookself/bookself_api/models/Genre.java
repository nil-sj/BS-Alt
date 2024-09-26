package com.bookself.bookself_api.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "genre", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String definition;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenreCategory category;

    // Constructors
    public Genre() {}

    public Genre(String name, String definition, GenreCategory category) {
        this.name = name;
        this.definition = definition;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public GenreCategory getCategory() {
        return category;
    }

    public String getCategoryDisplayName() {
        return category.getDisplayName();
    }

    public void setCategory(GenreCategory category) {
        this.category = category;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id) && Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}