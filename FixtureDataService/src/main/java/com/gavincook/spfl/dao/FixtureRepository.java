package com.gavincook.spfl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gavincook.spfl.model.Fixture;

public interface FixtureRepository extends JpaRepository<Fixture, Long> {

	List<Fixture> findByResourceId(Long resourceId);

	List<Fixture> findByHomeTeamResourceId(Long resourceId);

	List<Fixture> findByAwayTeamResourceId(Long resourceId);

	List<Fixture> findByLeagueResourceId(Long leagueResourceId);

	List<Fixture> findByStatusAndLeagueResourceId(String status, Long leagueResourceId);

	List<Fixture> findByStatusAndLeagueResourceIdOrderByFixtureDateTimeDesc(String status, Long leagueResourceId);
	
	List<Fixture> findByStatusInAndLeagueResourceId(List<String> statusList, Long leagueResourceId);
	
	List<Fixture> findByStatusInAndLeagueResourceIdOrderByFixtureDateTimeDesc(List<String> statusList, Long leagueResourceId);

}
