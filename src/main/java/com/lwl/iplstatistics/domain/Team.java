package com.lwl.iplstatistics.domain;

import java.util.List;

import lombok.Data;

@Data
public class Team {
	
		private String label;
		private String city;
		private String home;
		private String coach;
		private String name;
		private List<Player> players; 
}
