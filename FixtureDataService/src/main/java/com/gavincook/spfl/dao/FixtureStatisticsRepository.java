package com.gavincook.spfl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gavincook.spfl.model.FixtureStatistics;

public interface FixtureStatisticsRepository extends JpaRepository<FixtureStatistics, Long> {

	List<FixtureStatistics> findByFixtureResourceId(long fixtureResourceId);

}
