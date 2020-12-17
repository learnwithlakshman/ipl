package com.lwl.iplstatistics.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDTO {
	private String name;
	private String role;
	private double price;
	private String label;
}
