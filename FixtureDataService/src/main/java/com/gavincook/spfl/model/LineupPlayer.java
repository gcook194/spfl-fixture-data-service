package com.gavincook.spfl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "lineup_player")
public class LineupPlayer {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
    
    @JsonIgnoreProperties("squad")
    @ManyToOne(fetch = FetchType.EAGER)
    private Lineup lineup; 
    
    @Column(name = "player_resource_id")
	private long playerResourceId; 
    
    @Column(name = "team_resource_id")
	private long teamResourceId; 
    
    @Column(name = "name")
	private String name; 
    
    @Column(name = "position")
	private String position; 
    
    @Column(name = "number")
	private int number; 
    
    @Column(name = "is_substitute")
    private boolean substitute;

}
