package com.cristi;

public class Hero implements ICharacter {

    private ICharacter innerBeast;
    private ISpell MagicShield;
    private ISpell RapidStrike;

    public Hero(ICharacter innerBeast) {
        this.innerBeast = innerBeast;
        this.MagicShield = new MagicShield();
        this.RapidStrike = new RapidStrike();
    }

    @Override
    public boolean isAttackingFirst(ICharacter character) {
        return innerBeast.isAttackingFirst(character);
    }

    @Override
    public void attack(ICharacter defender) {
        innerBeast.attack(defender);
        if (RapidStrike.useSpell()) {
            innerBeast.attack(defender);
        }
    }

    @Override
    public boolean isDefeated() {
        return innerBeast.isDefeated();
    }

    @Override
    public boolean hasTheSameSpeedAs(int speed) {
        return innerBeast.hasTheSameSpeedAs(speed);
    }

    @Override
    public boolean isLessLuckyThan(ILuck luck) {
        return innerBeast.isLessLuckyThan(luck);
    }

    @Override
    public boolean isSlowerThan(int speed) {
        return innerBeast.isSlowerThan(speed);
    }

    @Override
    public void defend(int strength) {
        if (MagicShield.useSpell()) {
            innerBeast.defend(strength / 2);
        } else {
            innerBeast.defend(strength);
        }
    }

    @Override
    public String getName() {
        return innerBeast.getName();
    }
}
