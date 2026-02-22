package com.frodo.tidehaven.domain;

import com.frodo.tidehaven.domain.valueobjects.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The player's ship.
 * Owned by the Game aggregate root — state changes are only made
 * through Game, never directly by application services or adapters.
 */

public class Ship {

    private final String name;
    private final int cargoCapacity;
    private final List<Item> cargo;
    private int condition; // 0-100, zero means the ship is wrecked

    public Ship(String name, int cargoCapacity, int condition) {
        this.name = name;
        this.cargoCapacity = cargoCapacity;
        this.cargo = new ArrayList<>();
        this.condition = condition;
    }

    // --- Domain operations (package-private: only Game may call) ---
    void addItem(Item item) {
        if (cargo.size() >= cargoCapacity) {
            throw new IllegalStateException("Cargo hold is full.");
        }
        cargo.add(item);
    }

    void applyDamage(int amount) {
        this.condition = Math.max(0, condition - amount);
    }

    // --- Queries ---
    public boolean isWrecked()   { return condition == 0; }
    public String name()         { return name; }
    public int condition()       { return condition; }
    public int cargoCapacity()   { return cargoCapacity; }

    public List<Item> cargo() {
        return Collections.unmodifiableList(cargo);
    }
}