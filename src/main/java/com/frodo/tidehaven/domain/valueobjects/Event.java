package com.frodo.tidehaven.domain.valueobjects;

/**
 * Value object.
 * Events don't have identity — a storm event that happens on Island A is the same kind of thing whether it happens in game 1 or game 2.
 */
public record Event(
        String id,
        String description // e.g. "storm", "merchant", "shipwreck"
) {}
