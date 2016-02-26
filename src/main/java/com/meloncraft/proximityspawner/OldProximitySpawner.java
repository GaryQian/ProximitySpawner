/*package com.meloncraft.proximityspawner;

import org.bukkit.command.Command;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;
import java.util.Collection;

public final class ProximitySpawner extends JavaPlugin {
	 public void onEnable() {
             new Listeners(this);
	 }
	 public void onDisable() {
		 
	 }
         public Team team = new Team();
	 Server server;
	 Random gen = new Random();
	 int amount, dir, dist, i;
	 double x, z, y;
	 @Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	 	if (cmd.getName().equalsIgnoreCase("proxspawn")) { 
                    
                    Server server = sender.getServer();
                            
                    Collection<Player> playerCollection = server.getOnlinePlayers();
                    //Player[] players = (Player[])(playerCollection.toArray(new Player[playerCollection.size()]));
                    sender.sendMessage("Spawning Zombies!");
                    int pop = players.length;
                    Location loc;
                    Location loc2;
                    for (int count = 0;count < pop;count++){
		 	loc = players[count].getLocation();
		 	amount = gen.nextInt(6);
		 			
		 	if (amount == 4) {
		 		amount--;
		 	}
		 	dir = gen.nextInt(4);
		 	dist = gen.nextInt(10) + 5;
		 			
		 			
		 	x = 0;
		 	z = 0;
		 	y = 0;
		 	if (dir == 0) {
                            x += dist;
		 	}
		 	if (dir == 1) {
                            x -= dist;
		 	}
		 	if (dir == 2) {
                            z += dist;
		 	}
		 	if (dir == 3) {
                            z += dist;
		 	}
		 	boolean loop = true;
		 	while (loop){
                            loc.add(x, y, z);
                            loc2 = loc;
                            if (loc.getBlock().getType() == Material.AIR && loc2.getBlock().getType() == Material.AIR) {
			 	loop = false;
                            }
                            else {
                                loc.add(0, 1, 0);
                            }
		 	}
		 			
		 	i = 0;
		 	while (i < amount){
                            players[count].getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                                                //sender.sendMessage("spawn!");
                            i++;
		 	}
		 			
                    }
                    return true;
                } //If this has happened the function will return true. 
                         // If this hasn't happened the value of false will be returned.
                int count;
                //Listeners listeners = new Listeners();
                if (cmd.getName().equalsIgnoreCase("team")) {
                    count = 0;
                    sender.sendMessage("This command is still in development. Sorry!");
                    while (count < 50) {
                        if (team.requests[count].findTarget((Player)sender)) {
                            team.addTeam((Player)sender, team.requests[count].getIndex());
                            count++;
                        }
                    }
                    if (count != 0) {
                        sender.sendMessage("You have not been invited to a team!");
                    }
                    return true;
                }
                return false;
        }
        
}
         
*/