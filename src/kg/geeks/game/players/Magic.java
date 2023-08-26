package kg.geeks.game.players;

public class Magic extends Hero {
    private int boost = 10;

    public Magic(int health, int damage, int boost, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.boost = boost;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        System.out.println("Урон всех героев увеличен на "+ this.boost);
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() +this.boost);
        }

    }
}
