package com.careerit.cbook.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {

	private int cid;
	private String name;
	private String email;
	private String mobile;

}
