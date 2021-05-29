package com.cristi;

public class WildBeast implements ICharacter {
    public IHealth health;
    private int strength;
    private int defense;
    private int speed;
    private ILuck luck;
    private String name;

    public WildBeast(IHealth health, int strength, int defense, int speed, ILuck luck, String name) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.luck = luck;
        this.name = name;
    }

    @Override
    public boolean isAttackingFirst(ICharacter character) {
        if (character.hasTheSameSpeedAs(this.speed)) {
            return character.isLessLuckyThan(this.luck);
        }
        return character.isSlowerThan(this.speed);
    }

    @Override
    public void attack(ICharacter defender) {
        System.out.println(name + " attacked " + defender.getName());
        defender.defend(strength);
    }

    @Override
    public boolean isDefeated() {
        return health.isDead();
    }

    @Override
    public boolean hasTheSameSpeedAs(int speed) {
        return this.speed == speed;
    }

    @Override
    public boolean isLessLuckyThan(ILuck luck) {
        return luck.isLessLuckyThan(this.luck);
    }

    @Override
    public boolean isSlowerThan(int speed) {
        return this.speed < speed;
    }

    @Override
    public void defend(int strength) {
        if (luck.isLucky()) {
            System.out.println(name + " got lucky, the attacker missed");
            return;
        }
        health.applyDamage(computeDamage(strength));
        System.out.println(name + " has: " + health.getHealthValue() + "HP left");
    }

    private int computeDamage(int strength) {
        if (strength < defense) {
            return 0;
        }

        return strength - defense;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
