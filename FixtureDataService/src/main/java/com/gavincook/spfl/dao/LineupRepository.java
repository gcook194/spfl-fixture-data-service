package com.gavincook.spfl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gavincook.spfl.model.Lineup;

public interface LineupRepository extends JpaRepository<Lineup, Long> {

	List<Lineup> findByFixtureResourceId(long fixtureResourceId);

}
