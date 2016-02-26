/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.meloncraft.proximityspawner;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Gary
 */
public class Listeners implements Listener {
    ItemStack air = new ItemStack(Material.AIR);
    
    public Listeners(ProximitySpawner plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onSpawn(CreatureSpawnEvent event){
        if (event.getEntity() instanceof LivingEntity) {
            if (!(event.getEntity() instanceof HumanEntity) && (event.getEntityType() != EntityType.CHICKEN)) event.setCancelled(true);
        }
    }
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event){
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            
            if (damager.getItemInHand().getType() == Material.WOOD_PICKAXE ||
                damager.getItemInHand().getType() == Material.STONE_PICKAXE ||
                damager.getItemInHand().getType() == Material.IRON_PICKAXE ||
                damager.getItemInHand().getType() == Material.GOLD_PICKAXE ||
                damager.getItemInHand().getType() == Material.DIAMOND_PICKAXE ||
                damager.getItemInHand().getType() == Material.WOOD_AXE ||
                damager.getItemInHand().getType() == Material.STONE_AXE ||
                damager.getItemInHand().getType() == Material.IRON_AXE ||
                damager.getItemInHand().getType() == Material.GOLD_AXE ||
                damager.getItemInHand().getType() == Material.DIAMOND_AXE ||
                damager.getItemInHand().getType() == Material.WOOD_SPADE||
                damager.getItemInHand().getType() == Material.STONE_SPADE ||
                damager.getItemInHand().getType() == Material.IRON_SPADE ||
                damager.getItemInHand().getType() == Material.GOLD_SPADE ||
                damager.getItemInHand().getType() == Material.DIAMOND_SPADE ||
                damager.getItemInHand().getType() == Material.WOOD_HOE ||
                damager.getItemInHand().getType() == Material.STONE_HOE ||
                damager.getItemInHand().getType() == Material.IRON_HOE ||
                damager.getItemInHand().getType() == Material.GOLD_HOE ||
                damager.getItemInHand().getType() == Material.DIAMOND_HOE) {
                
                event.setDamage(event.getDamage() / 2);
            }
        }
    }
    //Bandage Healing
    /*@EventHandler
    public void onBandageUse(PlayerInteractEvent event){
        if (event.getMaterial() == Material.PAPER) {
            Player player = event.getPlayer();
            InventoryHolder playerInv = (InventoryHolder) player;
            Inventory inv = playerInv.getInventory();
            if (player.getHealth() < player.getMaxHealth() - 2) {
                player.setHealth(player.getHealth() + 2);
                
                ItemStack stack = inv.getItem(inv.first(Material.PAPER));
                if (stack.getAmount() == 1) {
                    inv.remove(stack);
                }
                else {
                    stack.setAmount(stack.getAmount() - 1);
                }
            }
            else if (player.getHealth() == player.getMaxHealth() - 1) {
                player.setHealth(player.getHealth() + 1);
                ItemStack stack = inv.getItem(inv.first(Material.PAPER));
                if (stack.getAmount() == 1) {
                    inv.remove(stack);
                }
                else {
                    stack.setAmount(stack.getAmount() - 1);
                }
            }
        }
    }
    public static Request[] requests = new Request[50];
    Team team = new Team();
    @EventHandler
    public void teamRequest(PlayerInteractEntityEvent event){
        if (event.getRightClicked() instanceof Player) {
            Player target = (Player) event.getRightClicked(), sender = event.getPlayer();
            target.sendMessage(sender.getName() + " wishes to team with you. Type /team to accept");
            sender.sendMessage("You have sent a team request to " + target.toString());
            team.createRequest(sender, target);
            /*int index = team.getTeamIndex(sender);
            if (index == -1) {
                index = team.createTeam(sender);
            }
            requests[index] = new Request(index);
            requests[index].addTarget(target);*/
            
        /*}
    }
    
    public void teamDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            int index = team.getTeamIndex((Player)event.getDamager());
            if (team.getTeamIndex((Player)event.getEntity()) == index) {
                event.setCancelled(true);
            }
        }
    }*/
}
