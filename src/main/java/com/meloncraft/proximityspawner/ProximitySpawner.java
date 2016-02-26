package com.meloncraft.proximityspawner;

import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;
import org.bukkit.World;

public final class ProximitySpawner extends JavaPlugin {
    public Team team = new Team();
    Server server;
    Random gen = new Random();
    int amount, distX, distZ;
    double x, z, y;
    public void onEnable() {
        new Listeners(this);
        this.saveDefaultConfig();
        this.getConfig();
    }
    public void onDisable() {
        
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("proxspawn")) {
            
            Server server = sender.getServer();
            
            //ArrayList<Player> players = server.getOnlinePlayers();
            //Player[] players = (Player[])(playerCollection.toArray(new Player[playerCollection.size()]));
            sender.sendMessage("Spawning chickens!");
            int pop = server.getOnlinePlayers().length;
            
            Location loc, loc2;
            
            amount = (int) (pop * this.getConfig().getDouble("multiplier") + 1);
            distX = gen.nextInt(10) - 5;
            distZ = gen.nextInt(10) - 5;
            World world = server.getWorld("world");
            
            x = this.getConfig().getDouble("x");
            z = this.getConfig().getDouble("y");
            y = this.getConfig().getDouble("z");
            //loc = new Location(world, this.getConfig().getDouble("x"), this.getConfig().getDouble("x"), this.getConfig().getDouble("z"));
            x += distX;
            z += distZ;
            loc = new Location(world, x, y + 5, z);
            
            //boolean loop = true;
            //int counter = 0;
            /*while (loop || counter == 10){
                loc2 = new Location(world, loc.getX(), loc.getY() + 1, loc.getZ());
                if (loc2.getBlock().getType() == Material.AIR && loc.getBlock().getType() == Material.AIR) {
                    loop = false;
                }
                counter++;
                //else {
                //loc.add(0, 1, 0);
                //}
            }*/
            for (int count = 0; count < amount; count++) {
                world.spawnEntity(loc, EntityType.CHICKEN);
            }
            return true;
        }
        return false;
    }
    
    
}


