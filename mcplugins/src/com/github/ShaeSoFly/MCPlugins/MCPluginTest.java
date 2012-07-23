package com.github.ShaeSoFly.MCPlugins;


import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.JavaPlugin;

public class MCPluginTest extends JavaPlugin implements Listener
{
	public void onEnable()
	{
		getLogger().info(this.toString() + " has been enabled. Registering events...");
		getServer().getPluginManager().registerEvents(this, this);
	}
 
	public void onDisable()
	{
		getLogger().info("My plugin has been disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	{
		Player player = null;
		if (sender instanceof Player) 
		{
			player = (Player) sender;
		}
	 
		if (cmd.getName().equalsIgnoreCase("blarg"))
		{ 
			// do something...
			player.setHealth(player.getHealth() - 1);
			player.sendMessage("Take that, bud.");
			Location loc = player.getLocation();
			player.getWorld().playEffect(loc, Effect.GHAST_SHRIEK,0);
			return true;
		} 
		
		return false;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
    public void onLogin(PlayerLoginEvent event) 
    {
    	getLogger().info("MCTest plugin - LOGIN!");
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerMove(PlayerMoveEvent event) 
    {

    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerAnimate(PlayerAnimationEvent event) 
    {
    	PlayerAnimationType animType = event.getAnimationType();
    	event.getPlayer().sendMessage(String.format("Got animation: %s", animType.name()));
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerAnimate(PlayerRespawnEvent event) 
    {
    	Location startLoc = event.getRespawnLocation();
    	event.getPlayer().sendMessage(ChatColor.RED + "Got RESPAWN at " + startLoc.toString());
    }
}


