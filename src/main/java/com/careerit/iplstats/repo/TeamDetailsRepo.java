package com.careerit.iplstats.repo;

import com.careerit.iplstats.domain.TeamDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamDetailsRepo extends JpaRepository<TeamDetails, UUID> {
}
