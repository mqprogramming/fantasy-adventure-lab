package RoleTests;

import Entities.Enemies.Goblin;
import Entities.Roles.Attackers.Barbarian;
import ItemsAndCreatures.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarbarianTest {

    private Barbarian barbarian;
    private Goblin goblin;

    @Before
    public void before() {
        barbarian = new Barbarian("Urk the Unclean");
        goblin = new Goblin("Grimy");
    }

    @Test
    public void hasProperties() {
        assertNotNull(barbarian.getCurrentWeapon());
        assertNotNull(barbarian.getArmour());

        assertEquals(7, barbarian.getAttackLevel());
        assertEquals(6, barbarian.getDefenceLevel());
        assertEquals(50, barbarian.getHealthLevel());
        assertEquals(7, barbarian.getRecoveryLevel());
        assertEquals(3, barbarian.getEvasionLevel());
    }

    @Test
    public void canGainWeapon() {
        barbarian.gainWeapon(Weapon.BROAD_SWORD);
        assertEquals(Weapon.BROAD_SWORD, barbarian.getWeapons().get("Broad Sword"));
    }

    @Test
    public void canSwitchWeapon() {
        barbarian.gainWeapon(Weapon.BROAD_SWORD);
        barbarian.changeWeapon("Broad Sword");
        assertEquals(Weapon.DAGGER, barbarian.getWeapons().get("Dagger"));
        assertEquals(Weapon.BROAD_SWORD, barbarian.getCurrentWeapon());
    }

    @Test
    public void canUseSpecial() {
        barbarian.recklessCharge(goblin);
        assertNotEquals(6, barbarian.getDefenceLevel());
    }

    @Test
    public void canFight() {
        boolean result = barbarian.fight(goblin);
        if (goblin.getHealthLevel() != 20) assertEquals(false, result);
    }

    @Test
    public void canMiss() {
        boolean result = barbarian.fight(goblin);
        if (goblin.getHealthLevel() == 20) assertEquals(true, result);
    }

}