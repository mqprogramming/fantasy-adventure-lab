package Entities.Roles.Attackers;

import Entities.Roles.Role;
import ItemsAndCreatures.Weapon;
import ItemsAndCreatures.Armour;

import java.util.HashMap;

public class Knight extends Attacker {

    public Knight(String name) {
        super(name);
        this.healthLevel = 50;
        this.attackLevel = 6;
        this.defenceLevel = 5;
        this.recoveryLevel = 7;
        this.evasionLevel = 3;
        this.armour = Armour.LIGHT_ARMOUR;
        this.weapons = new HashMap<String, Weapon>();
        this.currentWeapon = Weapon.DAGGER;
    }

    public void inspiringSpeech(Role player) {
        int attackLevel = player.getAttackLevel();
        player.setAttackLevel(attackLevel += 1);
        int defenceLevel = player.getDefenceLevel();
        player.setDefenceLevel(defenceLevel += 1);
    }
}
