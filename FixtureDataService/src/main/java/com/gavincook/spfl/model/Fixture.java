package com.gavincook.spfl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "fixture")
public class Fixture {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@Column(name="resource_id")
	private Long resourceId; 
	
	@Column(name="league_resource_id")
	private Long leagueResourceId; 
	
	@Column(name="fixture_date")
	private String fixtureDate; 
	
	@Column(name="referee")
	private String referee; 
	
	@Column(name="stadium")
	private String stadium;  
	
	@JsonProperty("round")
	@Column(name="round_str")
	private String roundStr; 
	
	@Column(name="home_goals")
	private Integer homeGoals;
	
	@Column(name="away_goals")
	private Integer awayGoals; 
	
	@Column(name="home_team_resource_id")
	private Integer homeTeamResourceId;  
	
	@Column(name="away_team_resource_id")
	private Integer awayTeamResourceId; 
	
	@Column(name="ht_score")
	private String halfTimeScore;
	
	@Column(name="ft_score")
	private String fullTimeScore; 
	
	@Column(name="et_score")
	private String extraTimeScore; 
	
	@Column(name="pens_score")
	private String penaltiesScore;
	
	@Column(name="home_team_name")
	private String homeTeamName; 
	
	@Column(name="away_team_name")
	private String awayTeamName; 
	
	@Column(name="home_team_badge")
	private String homeTeamBadge;
	
	@Column(name="away_team_badge")
	private String awayTeamBadge;
	
	@Column(name="league_name")
	private String leagueName;
	
	@Column(name="league_badge_url")
	private String leagueBadgeUrl;
	
	@Column(name="status")
	private String status;
}
