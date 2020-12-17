package com.lwl.iplstatistics.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleCountDTO {

		private String roleName;
		private long count;
}
