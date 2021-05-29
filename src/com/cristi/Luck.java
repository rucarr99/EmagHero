package com.cristi;

import java.util.Random;

public class Luck implements ILuck {
    private int luckValue;

    public Luck(int luckValue) {
        this.luckValue = luckValue;
    }

    @Override
    public boolean isLucky() {
        return new Random().nextInt(100) <= luckValue;
    }

    @Override
    public boolean isLessLuckyThan(ILuck luck) {
        return false;
    }

    @Override
    public boolean isLessLuckyThan(int luck) {
        return false;
    }
}
