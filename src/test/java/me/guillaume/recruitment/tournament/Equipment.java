package me.guillaume.recruitment.tournament;

public class Equipment {
    private String name;
    private int hp;
    private int damage;
    private boolean blockable;

    Equipment(String name, int hp, int damage, boolean blockable) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.blockable = blockable;
    }

    public boolean isBlockable() {
        return blockable;
    }

}
