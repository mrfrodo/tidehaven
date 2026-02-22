package com.frodo.tidehaven.domain;

import com.frodo.tidehaven.domain.valueobjects.Health;
import com.frodo.tidehaven.domain.valueobjects.PlayerId;

/**
 * The player (captain) of Tidehaven.
 * Owned by the Game aggregate root — state changes are only made
 * through Game, never directly by application services or adapters.
 */
public class Player {

    private final PlayerId id;
    // primitive obsession — what does this number mean?
    private int healthDoNotUse;
    // explicit domain concept — self-validating, meaningful
    private Health health;
    private int resources;

    public Player(PlayerId id, Health health, int resources) {
        this.id = id;
        this.health = health;
        this.resources = resources;
    }

    // --- Domain operations (called by Game) ---
    void applyHealthDelta(int delta) {
        this.health = health.adjust(delta);
    }

    void applyResourceDelta(int delta) {
        if (resources + delta < 0) {
            throw new IllegalStateException("Insufficient resources.");
        }
        this.resources += delta;
    }

    // --- Queries ---
    public boolean isDead() {
        return health.isZero();
    }

    public PlayerId id()   { return id; }
    public Health health() { return health; }
    public int resources() { return resources; }
}