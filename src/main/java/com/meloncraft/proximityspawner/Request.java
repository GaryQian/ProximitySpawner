/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.meloncraft.proximityspawner;

import java.util.List;
import org.bukkit.entity.Player;

/**
 *
 * @author Gary
 */
public class Request {
    List<Player> target;
    Player sender;
    int index;
    
    public Request(int ind) {
        index = ind;
    }
    
    public void addTarget(Player player) {
        target.add(player);
    }
    public void setSender(Player player) {
        sender = player;
    }
    
    public Player getSender() {
        return sender;
    }
    public boolean findTarget(Player player) {
        return target.contains(player);
    }
    
    public int getIndex() {
        return index;
    }
}
