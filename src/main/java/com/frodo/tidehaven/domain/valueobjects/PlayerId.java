package com.frodo.tidehaven.domain.valueobjects;

import java.util.UUID;

/**
 * Strongly Typed Identity
 * @param value
 */
public record PlayerId(String value) {
    public PlayerId {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("PlayerId cannot be blank.");
    }
}