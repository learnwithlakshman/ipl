package com.lwl.iplstatistics.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lwl.iplstatistics.dto.LabelDTO;
import com.lwl.iplstatistics.dto.PlayerDTO;
import com.lwl.iplstatistics.dto.RoleCountDTO;

public class IplStatServiceTest {

	@Test
	void testTeamLabels() {
		IplStatService service = new IplStatServiceImpl();
		LabelDTO labelDto = service.getTeamLabels();
		System.out.println(labelDto);
		assertEquals(8, labelDto.getLabels().size());
	}

	@Test
	void testPlayerByLabel() {
		IplStatService service = new IplStatServiceImpl();
		List<PlayerDTO> list = service.getPlayersByLabel("CSK");
		System.out.println(list);
		assertTrue(list.size()>0);
	}
	
	@Test
	void testRoleCount() {
		IplStatService service = new IplStatServiceImpl();
		List<RoleCountDTO> list = service.getRoleCountByLable("CSK");
		System.out.println(list);
		assertEquals(4, list.size());
	}
}
