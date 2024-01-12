package me.guillaume.recruitment.tournament;

import java.util.ArrayList;

public class Highlander {

    private int hp;
    private int damage;
    private ArrayList<Equipment> inventory;

    Highlander() {
        this.hp = 150;
        this.damage = 12;
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

    Highlander equip(String name){
        if (name.equals("Great Sword")) {
            inventory.add(new Equipment("Great Sword", 0, 0, true));
        }
        else {
            inventory.add(new Equipment(name, 0, 0, false));
        }
        return this;
    }

}
