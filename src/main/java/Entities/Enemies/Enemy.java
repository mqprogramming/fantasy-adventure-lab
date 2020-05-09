package Entities.Enemies;

import Entities.Entity;

public abstract class Enemy extends Entity {

    protected int xpDropped;

    public Enemy(String name) {
        super(name);
    }

    public int getXpDropped() {
        return xpDropped;
    }
}
