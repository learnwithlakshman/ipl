package com.lwl.iplstatistics.service;

import java.util.List;

import com.lwl.iplstatistics.dto.LabelDTO;
import com.lwl.iplstatistics.dto.PlayerDTO;
import com.lwl.iplstatistics.dto.RoleAmountDTO;
import com.lwl.iplstatistics.dto.RoleCountDTO;
import com.lwl.iplstatistics.dto.TeamAmountDTO;
import com.lwl.iplstatistics.dto.TeamDTO;

public interface IplStatService {

	public LabelDTO getTeamLabels();

	public List<PlayerDTO> getPlayersByLabel(String label);

	public List<RoleCountDTO> getRoleCountByLable(String label);

	public List<PlayerDTO> getPlayersByLabelAndRole(String label, String role);

	public List<TeamDTO> getTeamDetails();

	public List<TeamAmountDTO> getTeamAmountDetails();

	public List<RoleAmountDTO> getRoleAmountByLabelAndRole(String label, String role);
}
