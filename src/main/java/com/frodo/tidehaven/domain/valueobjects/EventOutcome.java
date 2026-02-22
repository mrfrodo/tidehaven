package com.frodo.tidehaven.domain.valueobjects;

/**
 * The outcome of a player's choice during an island event.
 */
public record EventOutcome(int healthDelta, int resourceDelta, String narrative) {}