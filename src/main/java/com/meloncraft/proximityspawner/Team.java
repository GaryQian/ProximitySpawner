/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.meloncraft.proximityspawner;

import org.bukkit.entity.Player;

/**
 *
 * @author Gary
 */
public class Team {
    public Team () {
        
    }
    static Player[][] teams = new Player[50][4];
    int count, count2, count3, count4, freeIndex;
    
    
    
    public int getTeamIndex(Player player) {
        int index = -1;
        count = 0;
        count2 = 0;
        while (count < 50) {
            while (count2 < 4) {
                if (player == teams[count][count2]) {
                    index = count;
                    count = 100;
                    count2 = 100;        
                }
                count2++;
            }
            count++;
        }
        
        return index;
    }
    
    public int findFreeIndex() {
        count = 0;
        count2 = 0;
        while (count < 50) {
            count3 = 0;
            while (count2 < 4) {
                if (null != teams[count][count2]) {
                    count3++;
                    count2 = 100;        
                }
                count2++;
            }
            if (count3 == 0) {
                freeIndex = count;
                count = 100;
            }
            else {
                count++;
            }
        }
        return freeIndex;
    }
    
    public String addTeam(Player player, int index) {
        String output;
        count2 = 0;
        count3 = 0;
        while (count2 < 4) {
            if (teams[index][count2] == null) {
                count3 = count2;
                count2 = 100;
            }
            count2++;
        }
        if (count3 == 0) {
            output = "This team is full! Please join another team!";
        }
        else {
            teams[index][count3] = player;
            output = "You have joined the team! Friendly meele damage is disabled!";
        }
        return output;
    }
    
    public int createTeam(Player player) {
        teams[freeIndex][1] = player;
        player.sendMessage("You have created a new team!");
        return freeIndex;
    }
    
    public void leaveTeam(Player player) {
        count2 = 0;
        while (count2 < 4) {
            if (teams[getTeamIndex(player)][count2] == player) {
                teams[getTeamIndex(player)][count2] = null;
                player.sendMessage("You have left your team.");
                count2 = 100;
            }
            count2++;
        }
        
    }
    
    public static Request[] requests = new Request[50];
    public void createRequest(Player sender, Player target) {
        int index = getTeamIndex(sender);
        if (index == -1) {
            index = createTeam(sender);
        }
        requests[index] = new Request(index);
        requests[index].addTarget(target);
            
    }
}
