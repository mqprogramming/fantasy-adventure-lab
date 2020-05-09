package Entities;

import java.util.Random;

public abstract class Entity {

    protected String name;
    protected int healthLevel;
    protected int attackLevel;
    protected int defenceLevel;
    protected int evasionLevel;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public int getDefenceLevel() {
        return defenceLevel;
    }

    public int getEvasionLevel() {
        return evasionLevel;
    }

    public void setEvasionLevel(int evasionLevel) {
        this.evasionLevel = evasionLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public void setDefenceLevel(int defenceLevel) {
        this.defenceLevel = defenceLevel;
    }

    public boolean fight(Entity entity) {
        boolean miss = false;
        // Damage calc
        int rand = new Random().nextInt(3 + 3) - 3;
        int damage = (attackLevel * 3) - (entity.defenceLevel * 2) + rand;
        if (damage < 1) damage = 1;
        // Evasion calc
        rand = new Random().nextInt(20);
        if (rand < entity.evasionLevel) {
            damage = 0;
            miss = true;
        }
        // Assigning damage
        int remainingHealth = entity.getHealthLevel() - damage;
        entity.setHealthLevel(remainingHealth);
        return miss;
    }
}
