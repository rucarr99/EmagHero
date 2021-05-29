package com.cristi;

import java.util.concurrent.ThreadLocalRandom;

public class Game implements IGame {
    private ICharacter attacker;
    private ICharacter defender;
    private int noOfRounds;

    public Game(int noOfRounds) {
        this.attacker = new Hero(new WildBeast(new Health(ThreadLocalRandom.current().nextInt(70, 100 + 1)),
                ThreadLocalRandom.current().nextInt(70, 80 + 1),
                ThreadLocalRandom.current().nextInt(40, 55 + 1),
                ThreadLocalRandom.current().nextInt(45, 50 + 1),
                new Luck(ThreadLocalRandom.current().nextInt(10, 30 + 1)),
                "Orderus"));
        this.defender = new WildBeast(new Health(ThreadLocalRandom.current().nextInt(60, 90 + 1)),
                ThreadLocalRandom.current().nextInt(60, 90 + 1),
                ThreadLocalRandom.current().nextInt(40, 60 + 1),
                ThreadLocalRandom.current().nextInt(40, 60 + 1),
                new Luck(ThreadLocalRandom.current().nextInt(25, 40 + 1)),
                "wild beast");
        this.noOfRounds = noOfRounds;
    }

    @Override
    public void start() {

        if (defender.isAttackingFirst(attacker)) {
            switchRoles();
        }


        for (int i = 0; i < noOfRounds; i++) {
            attacker.attack(defender);

            if (defender.isDefeated()) {
                break;
            }

            switchRoles();
        }
    }

    private void switchRoles() {
        ICharacter temp = attacker;
        attacker = defender;
        defender = temp;
    }


    @Override
    public void getWinner() {
        if (defender.isDefeated()) {
            System.out.println("The winner is: " + attacker.getName());
        } else {
            System.out.println("Draw");
        }
    }
}
