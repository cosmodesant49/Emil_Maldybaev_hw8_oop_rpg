package kg.geeks.game.players;

public class Witcher extends Hero{

    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.STAY_ALIVE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()==0){
                System.out.println("Герой воскрешен ценой жизни Witcher");
                heroes[i].setHealth(heroes[7].getHealth());
                heroes[7].setHealth(0);
            }
        }
    }
}
