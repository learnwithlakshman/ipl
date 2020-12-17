package com.lwl.iplstatistics.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamAmountDTO {

		private String label;
		private double amount;
}
