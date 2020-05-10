package ItemsAndCreatures;

public enum Creatures {

    SALAMANDER("Salamander", 1),
    PEGASUS("Pegasus", 2),
    DRAGON("Dragon", 3);

    private final String type;
    private final int defenceModifier;

    Creatures(String type, int defenceModifier) {
        this.type = type;
        this.defenceModifier = defenceModifier;
    }

}
