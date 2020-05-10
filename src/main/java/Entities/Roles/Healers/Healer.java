package Entities.Roles.Healers;

import Entities.Roles.Role;
import ItemsAndCreatures.Potion;

import java.util.HashMap;

public abstract class Healer extends Role {

    protected HashMap<String, Potion> potions;
    protected Potion currentPotion;

    public Healer(String name) {
        super(name);
    }

    public HashMap<String, Potion> getPotions() {
        return potions;
    }

    public Potion getCurrentPotion() {
        return currentPotion;
    }

    public void changePotion(String newPotion) {
        potions.put(currentPotion.getType(), currentPotion);
        Potion foundPotion = potions.remove(newPotion);
        currentPotion = foundPotion;
    }

    public void gainPotion(Potion potion) {
        potions.put(potion.getType(), potion);
    }
}
