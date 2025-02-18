package me.guillaume.recruitment.tournament;

import java.util.ArrayList;

public class Viking {

    private int hp;
    private int damage;
    private ArrayList<Equipment> inventory;

    Viking() {
        this.hp = 120;
        this.damage = 6;
        this.inventory = new ArrayList<Equipment>();

    }

    int hitPoints(){
        return hp;
    }

    void setHP(int newhp){
        hp = newhp;
    }

    int getDamage(){
        return damage;
    }

    Viking equip(String name){
        if (name.equals("buckler")) {
            inventory.add(new Equipment("buckler", 0, 0, true));
        }
        else {
            inventory.add(new Equipment(name, 0, 0, false));
        }
        return this;
    }

}
