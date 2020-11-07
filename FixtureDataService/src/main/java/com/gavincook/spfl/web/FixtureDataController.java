package com.gavincook.spfl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gavincook.spfl.dao.FixtureStatisticsRepository;
import com.gavincook.spfl.dao.LineupRepository;
import com.gavincook.spfl.model.FixtureStatistics;
import com.gavincook.spfl.model.FixtureStatisticsListResponse;
import com.gavincook.spfl.model.Lineup;
import com.gavincook.spfl.model.LineupListResponse;

@Controller
@RequestMapping("fixture-data")
public class FixtureDataController {
	
	private final LineupRepository lineupRepo; 
	private final FixtureStatisticsRepository fixtureStatsRepository; 
	
	@Autowired
	public FixtureDataController(
			LineupRepository lineupRepo, 
			FixtureStatisticsRepository fixtureStatsRepository) {
		this.lineupRepo = lineupRepo;
		this.fixtureStatsRepository = fixtureStatsRepository;
	}

	@GetMapping("/{fixtureResourceId}/lineups")
	public ResponseEntity<LineupListResponse> getLineupsByFixtureId(@PathVariable long fixtureResourceId) {
		
		LineupListResponse response = new LineupListResponse();
		
		List<Lineup> lineups = lineupRepo.findByFixtureResourceId(fixtureResourceId);
		
		if (lineups != null) {
			response.setLineups(lineups);
			response.setResults(lineups.size());
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{fixtureResourceId}/statistics")
	public ResponseEntity<FixtureStatisticsListResponse> getFixtureStatisticsByFixtureResourceId(@PathVariable long fixtureResourceId) {
		
		FixtureStatisticsListResponse response = new FixtureStatisticsListResponse();
		
		List<FixtureStatistics> statistics = fixtureStatsRepository.findByFixtureResourceId(fixtureResourceId);
		
		if (statistics != null) {
			response.setStatistics(statistics);
			response.setResults(statistics.size());
		}
		
		return ResponseEntity.ok(response);
	}
}
