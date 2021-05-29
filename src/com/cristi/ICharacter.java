package com.cristi;

public interface ICharacter {
    boolean isAttackingFirst(ICharacter character);
    void attack(ICharacter character);
    boolean isDefeated();
    boolean hasTheSameSpeedAs(int speed);
    boolean isLessLuckyThan(ILuck luck);
    boolean isSlowerThan(int speed);
    void defend(int damage);
    String getName();
}