package com.frodo.tidehaven.domain;

import com.frodo.tidehaven.domain.valueobjects.Event;
import com.frodo.tidehaven.domain.valueobjects.IslandId;

import java.util.List;

/**
 * A location the player can navigate to.
 * Owned by the Game aggregate root.
 */
public class Island {

    private final IslandId id;
    private final String name;
    private final List<Event> events;
    private boolean visited;

    public Island(IslandId id, String name, List<Event> events) {
        this.id = id;
        this.name = name;
        this.events = events;
        this.visited = false;
    }

    // --- Domain operations (package-private: only Game may call) ---
    void markVisited() {
        this.visited = true;
    }

    // --- Queries ---
    public IslandId id()          { return id; }
    public String name()          { return name; }
    public boolean isVisited()    { return visited; }
    public List<Event> events()   { return List.copyOf(events); }
}