package com.frodo.tidehaven.domain;

import com.frodo.tidehaven.domain.valueobjects.EventOutcome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aggregate root.
 *
 * Game is the main consistency boundary. All state changes to Player, Ship,
 * and Islands must go through Game — never directly.
 */
public class Game {

    private final String id;
    private final Player player;
    private final Ship ship;
    private final List<Island> islands;
    private Island currentIsland;
    private GameStatus status;

    public Game(String id, Player player, Ship ship, List<Island> islands, Island startingIsland) {
        this.id = id;
        this.player = player;
        this.ship = ship;
        this.islands = new ArrayList<>(islands);
        this.currentIsland = startingIsland;
        this.status = GameStatus.IN_PROGRESS;
    }

    // --- Commands ---
    public void navigateTo(Island destination) {
        if (status != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("Cannot navigate — game is not in progress.");
        }
        if (!islands.contains(destination)) {
            throw new IllegalArgumentException("Destination does not belong to this game.");
        }
        this.currentIsland = destination;
        destination.markVisited();
    }

    public void applyOutcome(EventOutcome outcome) {
        player.applyHealthDelta(outcome.healthDelta());
        player.applyResourceDelta(outcome.resourceDelta());
        if (player.isDead()) {
            this.status = GameStatus.LOST;
        }
    }

    // --- Queries ---
    public String id()            { return id; }
    public Player player()        { return player; }
    public Ship ship()            { return ship; }
    public Island currentIsland() { return currentIsland; }
    public GameStatus status()    { return status; }

    public List<Island> islands() {
        return Collections.unmodifiableList(islands);
    }

}
