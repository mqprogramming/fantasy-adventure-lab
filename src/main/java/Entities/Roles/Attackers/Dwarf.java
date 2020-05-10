package Entities.Roles.Attackers;

import ItemsAndCreatures.Weapon;
import ItemsAndCreatures.Armour;

import java.util.HashMap;

public class Dwarf extends Attacker {

    public Dwarf(String name) {
        super(name);
        this.armour = Armour.LIGHT_ARMOUR;
        this.weapons = new HashMap<String, Weapon>();
        this.currentWeapon = Weapon.DAGGER;
        this.healthLevel = 50;
        this.attackLevel = (6 + this.currentWeapon.getAttackModifier());
        this.defenceLevel = (5 + this.armour.getDefenceModifier());
        this.recoveryLevel = 7;
        this.evasionLevel = 3;
    }

    public void hunkerDown() {
        int attackLevel = getAttackLevel();
        setAttackLevel(attackLevel -= 1);
        int defenceLevel = getDefenceLevel();
        setDefenceLevel(defenceLevel += 2);
        int evasionLevel = getEvasionLevel();
        setEvasionLevel(evasionLevel -= 1);
    }
}
