package com.frodo.tidehaven.infrastructure.adapters.out.persistence;

import com.frodo.tidehaven.application.ports.out.GameStateRepositoryPort;
import com.frodo.tidehaven.domain.Game;
import org.springframework.stereotype.Repository;

/**
 * Driven adapter — implements GameStateRepositoryPort using Spring Data JDBC.
 * Translates between the domain model and the database.
 */
@Repository
public class JdbcGameRepository implements GameStateRepositoryPort {

    @Override
    public Game loadGame(String gameId) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void saveGame(Game game) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}