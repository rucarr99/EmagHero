package com.cristi;

public class MagicShield implements ISpell {
    private ILuck chance;

    public MagicShield() {
        this.chance = new Luck(20) {
        };
    }

    @Override
    public boolean useSpell() {
        if (chance.isLucky()) {
            System.out.println("Orderus uses magic shield.");
            return true;
        }
        return false;
    }
}
