package com.playernguyen;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerManager {

	// It is a seting player
	public UUID getUUID(Player p){
		return p.getUniqueId();
	}
	
	private File file = new File(NoSpam.getNoSpam().getDataFolder(), "player.yml");
	private YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(file);
	
	public static PlayerManager getPlayerManager(){
		return new PlayerManager();
	}
	
	public void setup(){
		if(file.exists()){
		}else
			try {
				yamlFile.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public Configuration getConfig(){
		return yamlFile;
	}
	
	public File getFile(){
		return file;
	}
	
	public void save(){
		try {
			yamlFile.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setMutePlayer(Player p, boolean mute){
		yamlFile.set(p.getUniqueId().toString() + ".name", p.getName());
		yamlFile.set(p.getUniqueId().toString() + ".mute", mute);
		save();
	}
	
	public boolean isMute(Player p){
		return yamlFile.getBoolean(p.getUniqueId().toString() + ".mute"); 
	}
	
}
