package com.frodo.tidehaven.application.ports.out;

import com.frodo.tidehaven.domain.Game;

/**
 * Driven port — defines how the application persists and retrieves game state.
 * Implemented by JdbcGameRepository in the infrastructure layer.
 */
public interface GameStateRepositoryPort {
    Game loadGame(String gameId);
    void saveGame(Game game);
}