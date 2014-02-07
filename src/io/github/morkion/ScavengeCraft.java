package io.github.morkion;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ScavengeCraft extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Block b = event.getBlock();
		Material bm = b.getType();
		if(bm == Material.DEAD_BUSH||bm == Material.CROPS||bm == Material.SUGAR_CANE_BLOCK||bm == Material.YELLOW_FLOWER||bm == Material.LONG_GRASS){
			ItemStack item = new ItemStack(Material.ARROW);
			b.getWorld().dropItem(b.getLocation(),item);
		}
	}
}
