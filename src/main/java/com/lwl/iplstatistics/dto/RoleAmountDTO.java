package com.lwl.iplstatistics.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleAmountDTO {

		private String role;
		private double amount;
}
