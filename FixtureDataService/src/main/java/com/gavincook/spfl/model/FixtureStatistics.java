package com.gavincook.spfl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "fixture_statistics")
public class FixtureStatistics {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
    
    @Column(name = "fixture_resource_id")
	private long fixtureResourceId; 
    
    @Column(name = "type")
	private String type; 
    
    @Column(name = "display_name")
	private String displayName; 
    
    @Column(name = "home_value")
	private long homeTeam; 
    
    @Column(name = "away_value")
	private long awayTeam; 

}
