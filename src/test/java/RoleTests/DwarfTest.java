package RoleTests;

import Entities.Enemies.Goblin;
import Entities.Roles.Attackers.Dwarf;
import ItemsAndCreatures.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DwarfTest {

    private Dwarf dwarf;
    private Goblin goblin;

    @Before
    public void before() {
        dwarf = new Dwarf("Meefeie");
        goblin = new Goblin("Grimy");
    }

    @Test
    public void hasProperties() {
        assertNotNull(dwarf.getCurrentWeapon());
        assertNotNull(dwarf.getArmour());

        assertEquals(7, dwarf.getAttackLevel());
        assertEquals(6, dwarf.getDefenceLevel());
        assertEquals(50, dwarf.getHealthLevel());
        assertEquals(7, dwarf.getRecoveryLevel());
        assertEquals(3, dwarf.getEvasionLevel());
    }

    @Test
    public void canGainWeapon() {
        dwarf.gainWeapon(Weapon.BROAD_SWORD);
        assertEquals(Weapon.BROAD_SWORD, dwarf.getWeapons().get("Broad Sword"));
    }

    @Test
    public void canSwitchWeapon() {
        dwarf.gainWeapon(Weapon.BROAD_SWORD);
        dwarf.changeWeapon("Broad Sword");
        assertEquals(Weapon.DAGGER, dwarf.getWeapons().get("Dagger"));
        assertEquals(Weapon.BROAD_SWORD, dwarf.getCurrentWeapon());
    }

    @Test
    public void canUseSpecial() {
        dwarf.hunkerDown();
        assertNotEquals(7, dwarf.getAttackLevel());
        assertNotEquals(6, dwarf.getDefenceLevel());
        assertNotEquals(3, dwarf.getEvasionLevel());
    }

    @Test
    public void canFight() {
        boolean result = dwarf.fight(goblin);
        if (goblin.getHealthLevel() != 20) assertEquals(false, result);
    }

    @Test
    public void canMiss() {
        boolean result = dwarf.fight(goblin);
        if (goblin.getHealthLevel() == 20) assertEquals(true, result);
    }

}
