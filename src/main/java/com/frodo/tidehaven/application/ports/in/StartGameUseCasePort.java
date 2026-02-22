package com.frodo.tidehaven.application.ports.in;

import com.frodo.tidehaven.domain.Game;

/**
 * Driving port — defines the start game operation.
 * Implemented by GameService, called by adapters (REST, web).
 */
public interface StartGameUseCasePort {
    Game startGame(String playerName);
}