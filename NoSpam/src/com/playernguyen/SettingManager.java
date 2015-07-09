package com.playernguyen;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

public class SettingManager {

	private File file = new File(NoSpam.getNoSpam().getDataFolder(), "config.yml");
	private YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(file);
	
	public static SettingManager getSettingManager(){
		return new SettingManager();
	}
	
	public void setup(){
		
		Logger log = Bukkit.getLogger();
		
		if(file.exists()){
			log.info("Da load config.");
		} else {
			log.info("Luu file config.yml.");
			yamlFile.options().copyDefaults(true);
			try {
				yamlFile.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	
}
