package com.frodo.tidehaven.domain.valueobjects;

/**
 * Unique identity of an island within a game.
 */
public record IslandId(String value) {
    public IslandId {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("IslandId cannot be blank.");
    }
}