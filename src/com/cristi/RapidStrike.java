package com.cristi;

public class RapidStrike implements ISpell {
    ILuck chance;

    public RapidStrike() {
        this.chance = new Luck(20) {
        };
    }

    @Override
    public boolean useSpell() {
        if (chance.isLucky()) {
            System.out.println("Orderus uses rapid strike.");
            return true;
        }
        return false;
    }
}

