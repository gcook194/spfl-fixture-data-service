package com.gavincook.spfl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "lineup")
public class Lineup {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
    
	@Column(name = "fixture_resource_id")
	private long fixtureResourceId;
	
	@Column(name = "team_resource_id")
	private long teamResourceId; 
	
    @Column(name = "manager_resource_id")
	private long managerResourceId; 
    
    @Column(name = "manager_name")
	private String manager; 
    
    @Column(name = "formation ")
	private String formation; 
    
    @JsonIgnoreProperties("lineup")
    @OneToMany(
            mappedBy = "lineup",
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
	private List<LineupPlayer> squad = new ArrayList<>(); 

}
