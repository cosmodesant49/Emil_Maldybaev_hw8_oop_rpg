package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;
public class Thor extends Hero{
    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.BASH, name);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int stun = RPG_Game.random.nextInt(100) + 1;
        if (stun <= 50) {
            boss.setStunned(true);
            System.out.println(this.getName() + " оглушил босса");
        }
    }
}
