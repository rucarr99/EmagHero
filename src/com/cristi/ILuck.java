package com.cristi;

public interface ILuck {
    boolean isLucky();
    boolean isLessLuckyThan(ILuck luck);
    boolean isLessLuckyThan(int luck);
}
