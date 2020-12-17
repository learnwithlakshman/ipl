package com.lwl.iplstatistics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.lwl.iplstatistics.domain.Player;
import com.lwl.iplstatistics.domain.Team;
import com.lwl.iplstatistics.dto.LabelDTO;
import com.lwl.iplstatistics.dto.PlayerDTO;
import com.lwl.iplstatistics.dto.RoleAmountDTO;
import com.lwl.iplstatistics.dto.RoleCountDTO;
import com.lwl.iplstatistics.dto.TeamAmountDTO;
import com.lwl.iplstatistics.dto.TeamDTO;
import com.lwl.iplstatistics.util.JsonReaderUtil;

public class IplStatServiceImpl implements IplStatService {

	private List<Team> teams;

	public IplStatServiceImpl() {
		teams = JsonReaderUtil.loadDataFromFile();
	}

	@Override
	public LabelDTO getTeamLabels() {
		List<String> labels = teams.stream().map(t -> t.getLabel()).collect(Collectors.toList());
		LabelDTO labelDTO = LabelDTO.builder().labels(labels).build();
		return labelDTO;
	}

	@Override
	public List<PlayerDTO> getPlayersByLabel(String label) {
		List<PlayerDTO> playerDtoList = new ArrayList<>();

		Optional<Team> optTeam = teams.stream().filter(t -> t.getLabel().equals(label)).findFirst();
		if (optTeam.isPresent()) {
			Team team = optTeam.get();
			List<Player> list = team.getPlayers();

			for (Player player : list) {
				PlayerDTO playerDto = PlayerDTO.builder().name(player.getName()).price(player.getPrice()).label(label)
						.role(player.getRole()).build();
				playerDtoList.add(playerDto);
			}

		} else {
			throw new IllegalArgumentException("Given label is not found :" + label);
		}

		return playerDtoList;
	}

	@Override
	public List<RoleCountDTO> getRoleCountByLable(String label) {

		List<RoleCountDTO> roleCountList = new ArrayList<>();
		Optional<Team> optTeam = teams.stream().filter(t -> t.getLabel().equals(label)).findFirst();
		if (optTeam.isPresent()) {
			Team team = optTeam.get();
			List<Player> playerList = team.getPlayers();
			
			Map<String, Long> map = playerList.stream()
					.collect(Collectors.groupingBy(Player::getRole, Collectors.counting()));

			map.entrySet().forEach(e -> {
				RoleCountDTO obj = RoleCountDTO.builder().roleName(e.getKey()).count(e.getValue()).build();
				roleCountList.add(obj);
			});

		} else {
			throw new IllegalArgumentException("Given label is not found :" + label);
		}
		return roleCountList;
	}

	@Override
	public List<PlayerDTO> getPlayersByLabelAndRole(String label, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamDTO> getTeamDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamAmountDTO> getTeamAmountDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleAmountDTO> getRoleAmountByLabelAndRole(String label, String role) {
		// TODO Auto-generated method stub
		return null;
	}

}
