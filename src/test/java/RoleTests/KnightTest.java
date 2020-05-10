package RoleTests;

import Entities.Enemies.Goblin;
import Entities.Roles.Attackers.Knight;
import ItemsAndCreatures.Weapon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {

    private Knight knight;
    private Goblin goblin;

    @Before
    public void before() {
        knight = new Knight("Sir Wilfred");
        goblin = new Goblin("Grimy");
    }

    @Test
    public void hasProperties() {
        assertNotNull(knight.getCurrentWeapon());
        assertNotNull(knight.getArmour());

        assertEquals(7, knight.getAttackLevel());
        assertEquals(6, knight.getDefenceLevel());
        assertEquals(50, knight.getHealthLevel());
        assertEquals(7, knight.getRecoveryLevel());
        assertEquals(3, knight.getEvasionLevel());
    }

    @Test
    public void canGainWeapon() {
        knight.gainWeapon(Weapon.BROAD_SWORD);
        assertEquals(Weapon.BROAD_SWORD, knight.getWeapons().get("Broad Sword"));
    }

    @Test
    public void canSwitchWeapon() {
        knight.gainWeapon(Weapon.BROAD_SWORD);
        knight.changeWeapon("Broad Sword");
        assertEquals(Weapon.DAGGER, knight.getWeapons().get("Dagger"));
        assertEquals(Weapon.BROAD_SWORD, knight.getCurrentWeapon());
    }

    @Test
    public void canUseSpecial() {
        knight.inspiringSpeech(knight);
        assertEquals(8, knight.getAttackLevel());
        assertEquals(7, knight.getDefenceLevel());
    }

    @Test
    public void canFight() {
        boolean result = knight.fight(goblin);
        if (goblin.getHealthLevel() != 20) assertEquals(false, result);
    }

    @Test
    public void canMiss() {
        boolean result = knight.fight(goblin);
        if (goblin.getHealthLevel() == 20) assertEquals(true, result);
    }

}
