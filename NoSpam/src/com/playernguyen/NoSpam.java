package com.playernguyen;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.playernguyen.cmds.MuteCmd;
import com.playernguyen.cmds.UnmuteCmd;
import com.playernguyen.listener.ListenerMain;

public class NoSpam extends JavaPlugin{

	// Source Code is up in GitHub
	public void onEnable(){
		Logger log = getLogger();
		
		log.info("Cai dat.....");
		
		// Setup File
		SettingManager.getSettingManager().setup();
		
		PlayerManager.getPlayerManager().setup();
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getServer().getPluginManager().registerEvents(new ListenerMain(), this);
		
		getCommand("mute").setExecutor(new MuteCmd());
		
		getCommand("unmute").setExecutor(new UnmuteCmd());
		
	}
	
	public static Plugin getNoSpam(){
		return Bukkit.getPluginManager().getPlugin("NoSpam");
	}
	
}
