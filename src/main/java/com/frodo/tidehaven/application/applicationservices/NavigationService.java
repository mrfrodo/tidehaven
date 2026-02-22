package com.frodo.tidehaven.application.applicationservices;

import com.frodo.tidehaven.application.ports.in.NavigationUseCasePort;
import com.frodo.tidehaven.application.ports.out.GameStateRepositoryPort;
import com.frodo.tidehaven.domain.Game;
import com.frodo.tidehaven.domain.Island;

/**
 * Application service — orchestrates navigation between islands.
 * Calls domain via Game aggregate root, persists via GameStateRepositoryPort.
 */
public class NavigationService implements NavigationUseCasePort {

    private final GameStateRepositoryPort gameRepository;

    public NavigationService(GameStateRepositoryPort gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void navigate(String gameId, Island destination) {
        Game game = gameRepository.loadGame(gameId);
        game.navigateTo(destination);
        gameRepository.saveGame(game);
    }
}