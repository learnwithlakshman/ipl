package com.lwl.iplstatistics.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LabelDTO {
	private List<String> labels;
}
