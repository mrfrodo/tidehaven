package com.frodo.tidehaven.domain.valueobjects;

/**
 * Something the player can carry in the ship's cargo hold.
 * Identified by name and type — two items with the same fields are the same item.
 */
public record Item(String name, ItemType type) {

    public Item {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Item name cannot be blank.");
    }
}
