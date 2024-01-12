package me.guillaume.recruitment.tournament;

public class Swordsman {
    private int hp;
    private int damage;

    Swordsman() {
        this.hp = 100;
        this.damage = 5;
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

    void engage(Viking vik){
        while ((hp>0 ) && (vik.hitPoints()>0)){
            hp = hp - vik.getDamage();
            if (hp<0){
                hp = 0;
            }
            vik.setHP(vik.hitPoints() - damage);
            if (vik.hitPoints()<0){
                    vik.setHP(0);
            }
        }
    }
}
