package me.guillaume.recruitment.tournament;

public class Viking {

    private int hp;
    private int damage;

    Viking() {
        this.hp = 120;
        this.damage = 6;
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

}
