package io.github.morkion;

import java.util.Random;

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
		if(new Random().nextInt(5)==0){
			if(bm == Material.DEAD_BUSH || bm == Material.CROPS || bm == Material.SUGAR_CANE_BLOCK || bm == Material.YELLOW_FLOWER || bm == Material.LONG_GRASS || bm == Material.RED_ROSE){
				ItemStack item = new ItemStack(Material.ROTTEN_FLESH);
				int amount = new Random().nextInt(30);
				short dmg = (short)new Random().nextInt(200);
				switch(new Random().nextInt(20)){
				case 0:
					item = new ItemStack(Material.ARROW,amount);
					break;
				case 1:
					item = new ItemStack(Material.APPLE, amount);
					break;
				case 2:
					item = new ItemStack(Material.BOW,1,dmg);
					break;
				case 3:
					item = new ItemStack(Material.CHAINMAIL_BOOTS,1,dmg);
					break;
				case 4:
					item = new ItemStack(Material.CHAINMAIL_CHESTPLATE,1,dmg);
					break;
				case 5:
					item = new ItemStack(Material.CHAINMAIL_HELMET,1,dmg);
					break;
				case 6:
					item = new ItemStack(Material.CHAINMAIL_LEGGINGS,1,dmg);
					break;
				case 7:
					item = new ItemStack(Material.STICK, amount);
					break;
				case 8:
					if(amount>10) amount-=10;
					item = new ItemStack(Material.IRON_INGOT, amount);
					break;
				case 9: 
					item = new ItemStack(Material.COAL, amount);
					break;
				case 10:
					item = new ItemStack(Material.WOOD_SWORD,1,dmg);
					break;
				case 11:
					item = new ItemStack(Material.GOLD_INGOT,amount);
					break;
				case 12:
					item = new ItemStack(Material.LEASH,amount);
					break;
				case 13:
					item = new ItemStack(Material.LEATHER, amount);
					break;
				case 14:
					if(amount>10) amount-=10;
					item = new ItemStack(Material.NAME_TAG, amount);
					break;
				case 15:
					item = new ItemStack(Material.SADDLE,1);
					break;
				case 16:
					item = new ItemStack(Material.STRING,amount);
					break;
				case 17:
					item = new ItemStack(Material.SULPHUR, amount);
					break;
				case 18:
					item = new ItemStack(Material.TORCH, amount);
					break;
				}
				b.getWorld().dropItem(b.getLocation(),item);
				if(item.getAmount()>1){
					event.getPlayer().sendMessage("You have found some stuff while scavenging...");
				}else{
					event.getPlayer().sendMessage("You have found something while scavenging...");
				}
			}
		}else{
			event.getPlayer().sendMessage("You haven't found anything while scavenging.");
		}
	}
}
