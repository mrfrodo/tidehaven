package com.frodo.tidehaven.application.ports.in;

import com.frodo.tidehaven.domain.Island;

/**
 * Driving port — defines what navigation operations the application exposes.
 * Implemented by NavigationService, called by adapters (REST, web).
 */
public interface NavigationUseCasePort {
    void navigate(String gameId, Island destination);
}
