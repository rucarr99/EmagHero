package com.cristi;

public class Health implements IHealth {
    private int healthValue;

    public Health(int healthValue) {
        this.healthValue = healthValue;
    }

    @Override
    public void applyDamage(int damage) {
        this.healthValue = healthValue - damage;
    }

    @Override
    public boolean isDead() {
        return healthValue <= 0;
    }

    public int getHealthValue() {
        return healthValue;
    }
}
