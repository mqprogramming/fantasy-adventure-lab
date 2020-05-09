package Entities.Enemies;

public class Goblin extends Enemy {

    public Goblin(String name) {
        super(name);
        this.xpDropped = 10;
        this.attackLevel = 4;
        this.defenceLevel = 3;
        this.healthLevel = 20;
        this.evasionLevel = 2;
    }
}
