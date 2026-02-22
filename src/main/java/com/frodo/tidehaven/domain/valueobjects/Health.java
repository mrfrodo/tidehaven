package com.frodo.tidehaven.domain.valueobjects;

/**
 * The health of a player, expressed as a non-negative integer.
 * A value of zero means the player is dead.
 */
public record Health(int value) {

    public Health {
        if (value < 0) throw new IllegalArgumentException("Health cannot be negative.");
    }

    public Health adjust(int delta) {
        int next = Math.max(0, value + delta);
        return new Health(next);
    }

    public boolean isZero() {
        return value == 0;
    }
}

