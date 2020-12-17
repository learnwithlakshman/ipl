package com.lwl.iplstatistics.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwl.iplstatistics.domain.Team;

public final class JsonReaderUtil {

	private static final String fileName = "/ipl2020.json";

	private JsonReaderUtil() {

	}

	public static List<Team> loadDataFromFile() {
		ObjectMapper mapper = new ObjectMapper();
		List<Team> teamList = new ArrayList<Team>();
		
		try {
			Team[] teams = mapper.readValue(JsonReaderUtil.class.getResourceAsStream(fileName),
					new TypeReference<Team[]>() {
					});

			teamList = Arrays.asList(teams);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return teamList;
	}

}
