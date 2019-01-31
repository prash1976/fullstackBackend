package com.prash.inform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prash.inform.model.Player;
import com.prash.inform.service.PlayerService;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public List<Player> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	
	@RequestMapping(value ="/players/{id}", method = RequestMethod.GET)
	public Player getPlayer(@PathVariable int id) {
		return playerService.getPlayer(id);
	}
	
	@RequestMapping(value ="/players/save" , method = RequestMethod.POST)
	public void savePlaper(@RequestBody Player player) {
		playerService.savePlayer(player);
	}
	
	@RequestMapping(value ="/players/update" , method = RequestMethod.PUT)
	public void updatePlaper(@RequestBody Player player) {
		playerService.updatePlayer(player);
	}
	
	@RequestMapping(value ="/players/delete/{id}" , method = RequestMethod.DELETE)
	public void deletePlaper(@PathVariable int id) {
		playerService.deletePlayer(id);
	}
	
	

}
