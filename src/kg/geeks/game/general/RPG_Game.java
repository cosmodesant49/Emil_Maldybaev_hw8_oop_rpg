package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(3000, 50, "Sargeros");
        Warrior warrior = new Warrior(290, 10, "Crown");
        Warrior warrior2 = new Warrior(270, 15, "Artur");
        Medic doc = new Medic(100, 5, 0, "Aibolit");
        Magic magic = new Magic(280, 20, 10,"Asta");
        Berserk berserk = new Berserk(260, 10, "Guts");
        Medic assistant = new Medic(300, 5, 0, "Strange");
        Thor thor = new Thor(300,1,"Thor");
        Witcher witcher = new Witcher(1000,0,"Geralt");
        Hero[] heroes = {warrior, warrior2, doc, magic, berserk, assistant,thor, witcher};

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " --------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
        System.out.println("++++++++++++");
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }
}
