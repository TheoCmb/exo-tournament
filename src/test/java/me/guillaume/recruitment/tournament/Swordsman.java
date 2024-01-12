package me.guillaume.recruitment.tournament;

import java.util.ArrayList;

public class Swordsman {
    private int hp;
    private int damage;
    private ArrayList<Equipment> inventory;


    Swordsman() {
        this.hp = 100;
        this.damage = 5;
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

    Swordsman equip(String name){
        if (name.equals("buckler")) {
            inventory.add(new Equipment("buckler", 0, 0, true));
        }
        else {
            inventory.add(new Equipment(name, 0, 0, false));
        }
        return this;
    }

    boolean blockableEquipment(){
        int capacity = inventory.size();
        for (Equipment equipment : inventory) {
            if (equipment.isBlockable()) {
                return true;
            }
        }
        return false;
    }

    int SwordsmanHPController(Viking vik){
        hp = hp - vik.getDamage();
        if (hp<0){
            hp = 0;
        }
        return hp;
    }

    int SwordsmanHPController(Highlander hl){
        hp = hp - (hl.getDamage()-4);
        if (hp<0){
            hp = 0;
        }
        return hp;
    }

    int VikingHPController(Viking vik){
        vik.setHP(vik.hitPoints() - damage);
        if (vik.hitPoints()<0){
            vik.setHP(0);
        }
        return vik.hitPoints();
    }

    int HighlanderHPController(Highlander hl){
        hl.setHP(hl.hitPoints() - (damage));
        if (hl.hitPoints()<0){
            hl.setHP(0);
        }
        return hl.hitPoints();
    }


    void engage(Viking vik){
        int tour=0;
        while ((hp>0 ) && (vik.hitPoints()>0)){
            //Gestion vie Swordsman
            if (blockableEquipment()){
                if (tour>=3){ //apres 3 coups, le bouclier de l'épéiste n'est plus utilisable
                    hp = SwordsmanHPController(vik);
                }
            }
            else {
                hp = SwordsmanHPController(vik);
            }

            //Gestion vie Viking
            if (blockableEquipment()){
                if (tour%2==0){ //le viking bloquera 1 coup sur 2
                    vik.setHP(VikingHPController(vik));
                }
            }
            else {
                vik.setHP(VikingHPController(vik));
            }

            tour++;
        }
    }

    void engage(Highlander hl){
        int fatigue = 0;
        int shield = 0;

        while ((hp>0 ) && (hl.hitPoints()>0)){
            //Gestion vie Swordsman
            if (blockableEquipment()){
                if (fatigue<2){
                    if (shield>0){
                        hp = SwordsmanHPController(hl);
                    }
                    shield++;
                }
            }

            fatigue++;

            //Gestion vie Highlander
            hl.setHP(HighlanderHPController(hl));

            if (shield == 2){
                shield = 0;
            }
            if (fatigue == 3){
                fatigue = 0;
            }
        }
    }
}
