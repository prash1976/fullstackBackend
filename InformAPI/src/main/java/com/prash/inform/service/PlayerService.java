package com.prash.inform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prash.inform.model.Player;

@Service
public class PlayerService {
	
	private List<Player> list = new ArrayList<Player>();
	
	public PlayerService() {
		System.out.println("Service Layer created!!");
		list.add(new Player(1,"PLayer1"));
		list.add(new Player(2,"PLayer2"));
		list.add(new Player(3,"PLayer3"));		
	}
	
	//get all players
	
	public List<Player> getAllPlayers() {
		return list;
	}
	
	//get player
	
	public Player getPlayer(int id) {
		
		for(Player p: list) {
			if(p.getId()==id) {
				return p;
			}
		} 
	 return null;
		
	}
	
	//save player 	
	public void savePlayer(Player player) {
		this.list.add(player);
	}
	//update player
	public void updatePlayer(Player player) {
		for(Player p : list) {
			if(p.getId() == player.getId()) {
				player.setPlayername(player.getPlayername());
			}
		}
		
	}
	
	//delete player
	public void deletePlayer(int id) {
		list.remove(id);
	}
	

}
