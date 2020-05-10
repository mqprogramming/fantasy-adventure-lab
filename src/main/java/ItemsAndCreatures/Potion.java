package ItemsAndCreatures;

import java.util.HashMap;

public class Potion {

    private String type;
    private HashMap<String, Integer> modifiers;

    public Potion(String type, HashMap<String, Integer> modifiers) {
        this.type = type;
        this.modifiers = modifiers;
    }

    public String getType() {
        return type;
    }

    public HashMap<String, Integer> getModifiers() {
        return modifiers;
    }
    
}
