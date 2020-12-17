package com.lwl.iplstatistics.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamDTO {
	private String label;
	private String city;
	private String home;
	private String coach;
	private String name;
}
