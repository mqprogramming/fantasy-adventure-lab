package ItemsAndCreatures;

public enum Armour {

    LIGHT_ARMOUR("Light Armour", 1),
    CHAINMAIL_ARMOUR("Chainmail Armour", 2),
    STEEL_ARMOUR("Steel Armour", 3),
    THICK_STEEL_ARMOUR("Thick Steel Armour", 4);

    private final String type;
    private final int defenceModifier;

    Armour(String type, int defenceModifier) {
        this.type = type;
        this.defenceModifier = defenceModifier;
    }

    public String getType() {
        return type;
    }

    public int getDefenceModifier() {
        return defenceModifier;
    }
}
