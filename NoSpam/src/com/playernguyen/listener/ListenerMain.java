package com.playernguyen.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.playernguyen.PlayerManager;
import com.playernguyen.SettingManager;

public class ListenerMain implements Listener{

	@EventHandler
	public void onPlayerAsyncChatEvent(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();

		for (String word : e.getMessage().split(" ")) {
            if (SettingManager.getSettingManager().getConfig().getStringList("config.Tu_Cam").contains(word)) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', SettingManager.getSettingManager().getConfig().getString("lang.Khong_Noi_Bay").replace("%player%", p.getName())));
            } else if(PlayerManager.getPlayerManager().isMute(p)){
    			e.setCancelled(true);
    			e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', SettingManager.getSettingManager().getConfig().getString("lang.Player_Mute")));
    		}
		}
			
	}
	
}
