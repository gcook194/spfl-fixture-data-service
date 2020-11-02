package com.gavincook.spfl.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gavincook.spfl.Constants;
import com.gavincook.spfl.dao.FixtureRepository;
import com.gavincook.spfl.model.Fixture;
import com.gavincook.spfl.model.FixtureListResponse;

@RestController
@RequestMapping("fixtures")
public class FixtureController {
	
	private FixtureRepository fixtureRepository; 

	@Autowired
	public FixtureController(FixtureRepository fixtureRepository) {
		this.fixtureRepository = fixtureRepository;
	}

	/**
	 * gets all fixtures
	 * @return
	 */
	@GetMapping
	public ResponseEntity<FixtureListResponse> getFixtures() {
		
		FixtureListResponse response = new FixtureListResponse();
		
		List<Fixture> fixtures = fixtureRepository.findAll();
		
		if (fixtures != null) {
			response.setFixtures(fixtures);
			response.setResults(fixtures.size());
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * gets a single fixture
	 * @param resourceId
	 * @return
	 */
	@GetMapping("/{resourceId}")
	public ResponseEntity<FixtureListResponse> getFixture(@PathVariable Long resourceId) {
		
		FixtureListResponse response = new FixtureListResponse();
		
		List<Fixture> fixtures = fixtureRepository.findByResourceId(resourceId);
		
		if (fixtures != null) {
			response.setFixtures(fixtures);
			response.setResults(fixtures.size());
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * finds a team's home or away fixtures
	 * @param teamType
	 * @param resourceId
	 * @return
	 */
	@GetMapping("/{teamType}/{resourceId}")
	public ResponseEntity<FixtureListResponse> getFixtureByHomeTeamId(@PathVariable String teamType, @PathVariable Long resourceId) {
		
		FixtureListResponse response = new FixtureListResponse();
		
		List<Fixture> fixtures = teamType.equals(Constants.HOME_TEAM_TYPE) ? 
				fixtureRepository.findByHomeTeamResourceId(resourceId) : fixtureRepository.findByAwayTeamResourceId(resourceId);
		
		if (fixtures != null) {
			response.setFixtures(fixtures);
			response.setResults(fixtures.size());
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * gets all a team's fixtures
	 * @param resourceId
	 * @return
	 */
	@GetMapping("/team/{teamResourceId}")
	public ResponseEntity<FixtureListResponse> getFixturesByTeam(@PathVariable Long teamResourceId) {
		
		FixtureListResponse response = new FixtureListResponse();
		
		List<Fixture> fixtures = fixtureRepository.findByResourceId(teamResourceId);
		
		if (fixtures != null) {
			response.setFixtures(fixtures);
			response.setResults(fixtures.size());
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * gets a teams fixtures by league ID
	 * @param leagueResourceId
	 * @return
	 */
	@GetMapping("/league/{leagueResourceId}")
	public ResponseEntity<FixtureListResponse> getFixturesByLeague(@PathVariable Long leagueResourceId) {
		
		FixtureListResponse response = new FixtureListResponse();
		
		List<Fixture> fixtures = fixtureRepository.findByLeagueResourceId(leagueResourceId);
		
		if (fixtures != null) {
			response.setFixtures(fixtures);
			response.setResults(fixtures.size());
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/status/{status}/league/{leagueResourceId}")
	public ResponseEntity<FixtureListResponse> getFixtureByStatusAndLeague(@RequestParam(required = false) String fixtureDateDesc, @PathVariable String status, @PathVariable Long leagueResourceId) {
		
		FixtureListResponse response = new FixtureListResponse();
		
		List<String> statuses = new ArrayList<>();
		
		//TODO move to manager/service class
		if (status.equals("unplayed")) {
			statuses.add("CANC");
			statuses.add("NS");
			statuses.add("PST");
		} else {
			statuses.add(status);
		}
		// END TODO
		
		List<Fixture> fixtures; 
		
		if (Boolean.valueOf(fixtureDateDesc)) {
			fixtures = fixtureRepository.findByStatusInAndLeagueResourceIdOrderByFixtureDateTimeDesc(statuses, leagueResourceId);
		} else {
			fixtures = fixtureRepository.findByStatusInAndLeagueResourceId(statuses, leagueResourceId);
		}
			
		if (fixtures != null) {
			response.setFixtures(fixtures);
			response.setResults(fixtures.size());
		}
		
		return ResponseEntity.ok().body(response);
	}
	
}
