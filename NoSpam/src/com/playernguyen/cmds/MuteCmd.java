package com.playernguyen.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.playernguyen.PlayerManager;
import com.playernguyen.SettingManager;

public class MuteCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		if(sender.hasPermission("nospam.mute") || sender.hasPermission("nospam.*")){
			if(args.length == 0){
				sender.sendMessage("Hay su dung: /mute [Player] hoac /nospam [Player]");
				return true;
			}
			
			@SuppressWarnings("deprecation")
			Player target = Bukkit.getServer().getPlayer(args[0]);
			
			if(target == null){
				sender.sendMessage("Nguoi choi nay khong co trong server.");
			}
			
			PlayerManager.getPlayerManager().setMutePlayer(target, true);
			
			target.sendMessage(ChatColor.translateAlternateColorCodes('&', SettingManager.getSettingManager().getConfig().getString("lang.Ban_Da_Bi_Mute")));
			
		} else {
			sender.sendMessage("lang.Khong_Co_Quyen");
		}
		
		return false;
	}

}
