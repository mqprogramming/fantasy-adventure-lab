package Entities.Roles.Attackers;

import Entities.Enemies.Enemy;
import ItemsAndCreatures.Weapon;
import ItemsAndCreatures.Armour;

import java.util.HashMap;
import java.util.Random;

public class Barbarian extends Attacker {

    public Barbarian(String name) {
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

    public void recklessCharge(Enemy enemy) {
        // Temporary Attack Boost
        int attackLevel = getAttackLevel();
        setAttackLevel(attackLevel += 3);
        // Attack Enemy
        fight(enemy);
        // Lose Boost
        attackLevel = getAttackLevel();
        setAttackLevel(attackLevel -= 3);
        // Perma Def Debuff
        int defenceLevel = getDefenceLevel();
        int rand = new Random().nextInt(3 - 1) + 1;
        System.out.println(rand);
        setDefenceLevel(defenceLevel -= rand);
    }
}

