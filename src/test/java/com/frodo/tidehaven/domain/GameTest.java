package com.frodo.tidehaven.domain;

import com.frodo.tidehaven.domain.valueobjects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Island startingIsland;
    private Island otherIsland;
    private Game game;

    @BeforeEach
    void setUp() {
        startingIsland = new Island(new IslandId("island-1"), "Crestfall", List.of());
        otherIsland    = new Island(new IslandId("island-2"), "Mireport", List.of());

        Player player = new Player(new PlayerId("player-1"), new Health(100), 50);
        Ship ship     = new Ship("The Wanderer", 10, 100);

        game = new Game("game-1", player, ship, List.of(startingIsland, otherIsland), startingIsland);
    }

    @Test
    void navigateTo_validDestination_updatesCurrentIsland() {
        game.navigateTo(otherIsland);
        assertEquals(otherIsland, game.currentIsland());
    }

    @Test
    void navigateTo_marksDestinationAsVisited() {
        game.navigateTo(otherIsland);
        assertTrue(otherIsland.isVisited());
    }

    @Test
    void navigateTo_islandNotInGame_throwsException() {
        Island foreignIsland = new Island(new IslandId("island-99"), "Nowhere", List.of());
        assertThrows(IllegalArgumentException.class, () -> game.navigateTo(foreignIsland));
    }

    @Test
    void applyOutcome_lethalDamage_setsStatusToLost() {
        EventOutcome lethal = new EventOutcome(-999, 0, "A storm destroys everything.");
        game.applyOutcome(lethal);
        assertEquals(GameStatus.LOST, game.status());
    }

    @Test
    void applyOutcome_nonLethalDamage_gameStillInProgress() {
        EventOutcome minor = new EventOutcome(-10, 0, "A minor skirmish.");
        game.applyOutcome(minor);
        assertEquals(GameStatus.IN_PROGRESS, game.status());
    }

}
