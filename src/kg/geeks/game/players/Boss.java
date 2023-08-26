package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;
    private boolean stunned;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
        this.stunned=false;
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence() {
        SuperAbility[] values = SuperAbility.values();
        int index = RPG_Game.random.nextInt(values.length);
        this.defence = values[index];
    }

    public void attack(Hero[] heroes) {
        if (isStunned()) {
            deleteStun();
            System.out.println("Босс оглушен и пропускает ход!");
            return;}
            for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk && heroes[i].getAbility() != this.defence) {
                    int blocked;
                    if (RPG_Game.random.nextBoolean()) { // true || false
                        blocked = this.getDamage() / 2; // 50 / 2 = 25
                    } else {
                        blocked = this.getDamage() / 5; // 50 / 5 = 10
                    }
                    ((Berserk) heroes[i]).setBlockedDamage(blocked);
                    heroes[i].setHealth(heroes[i].getHealth() - (this.getDamage() - blocked));


                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }
    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public void deleteStun() {
        this.stunned = false;
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " DEFENCE: " + this.defence + "\n";
    }
}